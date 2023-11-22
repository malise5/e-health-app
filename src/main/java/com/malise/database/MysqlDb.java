package com.malise.database;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import com.malise.app.model.entity.Apparatus;
import com.malise.app.model.entity.Doctor;
import com.malise.app.model.entity.User;
import com.malise.app.model.entity.Ward;
import com.malise.database.helper.DbTable;
import com.malise.database.helper.DbTableColumn;
import com.malise.database.helper.DbTableId;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.util.StringUtils;

public class MysqlDb implements Serializable {

  // private static final String URL = "jdbc:mysql://localhost:3306/hospital";

  // private static final String USER = "root";

  // private static final String PASSWORD = "root";

  private static MysqlDb database;

  private Connection connection;

  private MysqlDb() throws SQLException, NamingException {

    Context ctx = new InitialContext();
    DataSource dataSource = (DataSource) ctx.lookup("java:jboss/datasources/hospital");
    connection = dataSource.getConnection();

    // MysqlDataSource datasource = new MysqlDataSource();
    // datasource.setUrl(URL);
    // datasource.setUser(USER);
    // datasource.setPassword(PASSWORD);
    // connection = datasource.getConnection();

  }

  public static MysqlDb getInstance() {
    if (database == null) {
      try {
        database = new MysqlDb();

      } catch (SQLException | NamingException e) {
        e.printStackTrace();
      }

    }

    return database;
  }

  public static void updateSchema() {

    System.out.println("***********Updating Database Schema*************");

    try {
      Connection conn = MysqlDb.getInstance().getConnection();

      List<Class<?>> entities = new ArrayList<>();
      entities.add(User.class);
      entities.add(Doctor.class);
      entities.add(Ward.class);
      entities.add(Apparatus.class);

      for (Class<?> clazz : entities) {
        if (!clazz.isAnnotationPresent(DbTable.class)) {
          continue;
        }

        System.out.println("**********************************************************");
        System.out.println("Creating table for: " + clazz.getSimpleName());
        System.out.println("**********************************************************");

        DbTable dbTable = clazz.getAnnotation(DbTable.class);

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("create table if not exists ").append(dbTable.nameOfTable()).append("(");

        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

        for (Field field : fields) {
          if (!field.isAnnotationPresent(DbTableColumn.class)) {
            continue;
          }

          DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);
          sqlBuilder.append(dbTableColumn.name()).append(" ")
              .append(dbTableColumn.defination())
              .append(field.isAnnotationPresent(DbTableId.class) ? " NOT NULL AUTO_INCREMENT PRIMARY KEY" : "")
              .append(",");

        }

        sqlBuilder.append(")");

        String tableCreationSql = sqlBuilder.toString().replace(",)", ")");

        System.out.println("**********************************************************");
        System.out.println("Creating table: " + tableCreationSql);
        System.out.println("**********************************************************");

        conn.prepareStatement(tableCreationSql).executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  // saveorupdate
  // public static void insert(Object entity) {

  // try {

  // Class<?> clazz = entity.getClass();
  // if (!clazz.isAnnotationPresent(DbTable.class))
  // return;

  // DbTable dbTable = clazz.getAnnotation(DbTable.class);

  // List<Field> fields = new
  // ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
  // fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

  // StringBuilder columnBuilder = new StringBuilder();
  // StringBuilder paramPlaceHolderBuilder = new StringBuilder();
  // List<Object> parameters = new ArrayList<>();

  // for (Field field : fields) {
  // if (!field.isAnnotationPresent(DbTableColumn.class) ||
  // field.isAnnotationPresent(DbTableId.class))
  // continue;

  // field.setAccessible(true);
  // if (field.get(entity) == null)
  // continue;

  // DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

  // columnBuilder.append(dbTableColumn.name()).append(",");
  // paramPlaceHolderBuilder.append("?").append(",");
  // parameters.add(field.get(entity));

  // }

  // String queryBuilder = "insert into " +
  // dbTable.nameOfTable() +
  // "(" +
  // columnBuilder +
  // ")" +
  // " values(" +
  // paramPlaceHolderBuilder +
  // ")";

  // String query = queryBuilder.replace(",)", ")");
  // System.out.println("***************************************************");
  // System.out.println("Query: " + query);
  // System.out.println("***************************************************");

  // PreparedStatement sqlStmt = MysqlDb.getInstance().getConnection()
  // .prepareStatement(query);

  // int paramIdx = 1;
  // for (Object param : parameters) {
  // if (param.getClass().isAssignableFrom(BigDecimal.class))
  // sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) param);
  // else if (param.getClass().isAssignableFrom(Long.class))
  // sqlStmt.setLong(paramIdx++, (long) param);
  // else
  // sqlStmt.setString(paramIdx++, (String) param);
  // }

  // sqlStmt.executeUpdate();

  // } catch (Exception e) {
  // e.printStackTrace();
  // }
  // }

  // demo
  public static void insert(Object entity) {
    try {
      Class<?> clazz = entity.getClass();
      if (!clazz.isAnnotationPresent(DbTable.class))
        return;

      DbTable dbTable = clazz.getAnnotation(DbTable.class);

      List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
      fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

      StringBuilder columnBuilder = new StringBuilder();
      StringBuilder paramPlaceHolderBuilder = new StringBuilder();
      List<Object> parameters = new ArrayList<>();

      for (Field field : fields) {
        if (!field.isAnnotationPresent(DbTableColumn.class) || field.isAnnotationPresent(DbTableId.class))
          continue;

        field.setAccessible(true);
        if (field.get(entity) == null)
          continue;

        DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

        columnBuilder.append(dbTableColumn.name()).append(",");
        paramPlaceHolderBuilder.append("?").append(",");
        parameters.add(convertType(field.get(entity), field.getType()));
      }

      String queryBuilder = "insert into " +
          dbTable.nameOfTable() +
          "(" +
          columnBuilder +
          ")" +
          " values(" +
          paramPlaceHolderBuilder +
          ")";

      String query = queryBuilder.replace(",)", ")");
      System.out.println("***************************************************");
      System.out.println("Query: " + query);
      System.out.println("***************************************************");

      PreparedStatement sqlStmt = MysqlDb.getInstance().getConnection().prepareStatement(query);

      int paramIdx = 1;
      for (Object param : parameters) {
        if (param.getClass().isAssignableFrom(BigDecimal.class))
          sqlStmt.setBigDecimal(paramIdx++, (BigDecimal) param);
        else if (param.getClass().isAssignableFrom(Long.class))
          sqlStmt.setLong(paramIdx++, (long) param);
        else
          sqlStmt.setString(paramIdx++, (String) param);
      }

      sqlStmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static Object convertType(Object value, Class<?> targetType) {
    if (targetType.isAssignableFrom(BigDecimal.class)) {
      return new BigDecimal(value.toString());
    } else if (targetType.isAssignableFrom(Long.class)) {
      return Long.parseLong(value.toString());
    } else {
      return value.toString();
    }
  }

  // demo
  // part3
  public static <T> List<T> select(Class<T> filter) {
    try {
      Class<?> clazz = filter;

      if (!clazz.isAnnotationPresent(DbTable.class))
        return new ArrayList<>();

      DbTable dbTable = clazz.getAnnotation(DbTable.class);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SELECT * FROM ")
          .append(dbTable.nameOfTable()).append(";");
      Connection conn = MysqlDb.getInstance().getConnection();
      PreparedStatement preparedStatement = conn.prepareStatement(stringBuilder.toString());
      ResultSet resultSet = preparedStatement.executeQuery();
      List<T> result = new ArrayList<>();

      System.out.println("****************************************************************");
      System.out.println("Executing SQL query: " + stringBuilder.toString());
      System.out.println("****************************************************************");

      while (resultSet.next()) {
        T object = (T) clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
          DbTableColumn dbColumn = field.getAnnotation(DbTableColumn.class);
          if (dbColumn != null) {
            String columnName = dbColumn.name();

            Object value = resultSet.getObject(columnName);
            field.setAccessible(true);

            // Perform type conversion before setting the field
            Object convertedValue = convertToFieldType(value, field.getType());
            field.set(object, convertedValue);

            //
            System.out.println("****************************************************************");
            System.out.println("Setting " + field.getName() + " to " + convertedValue);

            System.out.println("****************************************************************");

          }
        }

        result.add(object);
      }
      return result;

    } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException
        | NoSuchMethodException ex) {
      throw new RuntimeException(ex);
    }
  }

  private static Object convertToFieldType(Object value, Class<?> targetType) {
    if (value == null || targetType.isAssignableFrom(value.getClass())) {
      return value;
    }

    if (targetType == Integer.class || targetType == int.class) {
      return Integer.parseInt(value.toString());
    }
    // Add other type conversions as needed

    return value;
  }

  // part 2
  // public static <T> List<T> select(T entity) {

  // List<T> resultList = new ArrayList<T>();

  // try {

  // Class<?> clazz = entity.getClass();

  // if (!clazz.isAnnotationPresent(DbTable.class)) {
  // return resultList;
  // }

  // DbTable dbTable = clazz.getAnnotation(DbTable.class);

  // String tableAlias = dbTable.nameOfTable().charAt(0) + "_e_";
  // System.out.println("table alias " + tableAlias);

  // List<Field> fields = new
  // ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
  // fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

  // StringBuilder columnBuilder = new StringBuilder();
  // StringBuilder paramPlaceHolderBuilder = new StringBuilder();
  // List<Object> whereParams = new ArrayList<>();

  // DateConverter converter = new DateConverter(null);
  // converter.setPattern("yyyy-mm-dd");
  // ConvertUtils.register(converter, Date.class);

  // for (Field field : fields) {

  // if (!field.isAnnotationPresent(DbTableColumn.class) ||
  // field.isAnnotationPresent(DbTableId.class)) {
  // continue;
  // }
  // DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

  // columnBuilder.append(tableAlias).append(".").append(dbTableColumn.name()).append(",");

  // field.setAccessible(true);
  // if (field.get(entity) != null) {
  // paramPlaceHolderBuilder
  // .append(whereParams.isEmpty() ? "" : " and ")
  // .append(tableAlias).append(".").append(dbTableColumn.name()).append("=?");
  // whereParams.add(field.get(entity));
  // }

  // }

  // String queryBuilder = "select " +
  // columnBuilder +
  // " from " +
  // dbTable.nameOfTable() + " " + tableAlias +
  // (whereParams.isEmpty() &&
  // org.apache.commons.lang3.StringUtils.isBlank(paramPlaceHolderBuilder) ? ""
  // : " where " + paramPlaceHolderBuilder);

  // String query = queryBuilder.replace(", from", " from");
  // System.out.println("Query: " + query);

  // PreparedStatement sqlStatement =
  // MysqlDb.getInstance().getConnection().prepareStatement(query);

  // int paramIdx = 1;
  // for (Object whereParam : whereParams) {
  // if (whereParam.getClass().isAssignableFrom(BigDecimal.class)) {
  // sqlStatement.setBigDecimal(paramIdx++, (BigDecimal) whereParam);
  // } else if (whereParam.getClass().isAssignableFrom(Long.class)) {
  // sqlStatement.setLong(paramIdx++, (long) whereParam);
  // } else
  // sqlStatement.setString(paramIdx++, (String) whereParam);

  // }

  // ResultSet resultSet = sqlStatement.executeQuery();
  // ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
  // int resultSetMetaDataCnt = resultSetMetaData.getColumnCount();

  // while (resultSet.next()) {
  // T bean = (T) entity.getClass().getDeclaredConstructor().newInstance();

  // for (int i = 0; i <= resultSetMetaDataCnt; i++) {
  // String colName = resultSetMetaData.getColumnName(i);
  // for (Field field : fields) {
  // if (!field.isAnnotationPresent(DbTableColumn.class) ||
  // field.isAnnotationPresent(DbTableId.class)) {
  // continue;
  // }
  // DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

  // field.setAccessible(true);
  // if (dbTableColumn.name().equals(colName)) {
  // BeanUtils.setProperty(bean, field.getName(), resultSet.getObject(i));
  // break;
  // }
  // }

  // }
  // resultList.add(bean);

  // }

  // } catch (Exception e) {
  // e.printStackTrace();
  // }

  // return resultList;

  // }

  public Connection getConnection() {
    return connection;
  }

  public void setConnection(Connection connection) {
    this.connection = connection;
  }

}

// public static String sanitizeValue(Object value) {
// if (value.getClass().isAssignableFrom(String.class)) {
// return "'" + value + "'";
// }
// return value.toString(); // or + ""
// }

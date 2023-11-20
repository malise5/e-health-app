package com.malise.database;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.malise.app.model.entity.Apparatus;
import com.malise.app.model.entity.Doctor;
import com.malise.app.model.entity.User;
import com.malise.app.model.entity.Ward;
import com.malise.database.helper.DbTable;
import com.malise.database.helper.DbTableColumn;
import com.malise.database.helper.DbTableId;
import com.mysql.cj.jdbc.MysqlDataSource;

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
        parameters.add(field.get(entity));

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

      PreparedStatement sqlStmt = MysqlDb.getInstance().getConnection()
          .prepareStatement(query);

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

// package com.malise.database;

// import java.io.Serializable;
// import java.lang.reflect.Field;
// import java.lang.reflect.InvocationTargetException;
// import java.math.BigDecimal;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// import javax.annotation.PostConstruct;
// import javax.ejb.Singleton;
// import javax.ejb.Startup;
// import javax.inject.Inject;
// import javax.naming.Context;
// import javax.naming.InitialContext;
// import javax.naming.NamingException;
// import javax.sql.DataSource;
// import com.malise.app.model.entity.Apparatus;
// import com.malise.app.model.entity.Doctor;
// import com.malise.app.model.entity.User;
// import com.malise.app.model.entity.Ward;
// import com.malise.database.helper.DbTable;
// import com.malise.database.helper.DbTableColumn;
// import com.malise.database.helper.DbTableId;

// @Singleton
// @Startup()
// public class MysqlDb implements Serializable {

// // private static MysqlDb database;

// private Connection connection;

// /**
// * The function initializes a connection to a database and updates its schema.
// */
// @PostConstruct
// private void init() throws SQLException, NamingException {

// Context ctx = new InitialContext();
// DataSource dataSource = (DataSource)
// ctx.lookup("java:jboss/datasources/hospital");
// connection = dataSource.getConnection();

// this.updateSchema();

// }

// /**
// * The function `updateSchema()` creates database tables based on the
// * annotations present in the
// * specified entity classes.
// */
// public void updateSchema() {

// System.out.println("***********Updating Database Schema*************");

// try {
// // Connection conn = MysqlDb.getInstance().getConnection();

// List<Class<?>> entities = new ArrayList<>();
// entities.add(User.class);
// entities.add(Doctor.class);
// entities.add(Ward.class);
// entities.add(Apparatus.class);

// for (Class<?> clazz : entities) {
// if (!clazz.isAnnotationPresent(DbTable.class)) {
// continue;
// }

// System.out.println("**********************************************************");
// System.out.println("Creating table for: " + clazz.getSimpleName());
// System.out.println("**********************************************************");

// DbTable dbTable = clazz.getAnnotation(DbTable.class);

// StringBuilder sqlBuilder = new StringBuilder();

// sqlBuilder.append("create table if not exists
// ").append(dbTable.nameOfTable()).append("(");

// List<Field> fields = new
// ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
// fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

// for (Field field : fields) {
// if (!field.isAnnotationPresent(DbTableColumn.class)) {
// continue;
// }

// DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);
// sqlBuilder.append(dbTableColumn.name()).append(" ")
// .append(dbTableColumn.defination())
// .append(field.isAnnotationPresent(DbTableId.class) ? " NOT NULL
// AUTO_INCREMENT PRIMARY KEY" : "")
// .append(",");

// }

// sqlBuilder.append(")");

// String tableCreationSql = sqlBuilder.toString().replace(",)", ")");

// System.out.println("**********************************************************");
// System.out.println("Creating table: " + tableCreationSql);
// System.out.println("**********************************************************");

// connection.prepareStatement(tableCreationSql).executeUpdate();
// }
// } catch (SQLException e) {
// e.printStackTrace();
// }

// }

// // e.printStackTrace();
// // }
// // }

// // demo
// // The below code is a method called "insert" that inserts an object into a
// // database table.
// public void insert(Object entity) {
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
// parameters.add(convertType(field.get(entity), field.getType()));
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

// PreparedStatement sqlStmt = connection.prepareStatement(query);

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

// private Object convertType(Object value, Class<?> targetType) {
// if (targetType.isAssignableFrom(BigDecimal.class)) {
// return new BigDecimal(value.toString());
// } else if (targetType.isAssignableFrom(Long.class)) {
// return Long.parseLong(value.toString());
// } else {
// return value.toString();
// }
// }

// // demo
// // part3
// // The below code is a method called "select" that retrieves data from a
// // database table based on a
// // given filter class.
// public <T> List<T> select(Class<T> filter) {
// try {
// Class<?> clazz = filter;

// if (!clazz.isAnnotationPresent(DbTable.class))
// return new ArrayList<>();

// DbTable dbTable = clazz.getAnnotation(DbTable.class);

// StringBuilder stringBuilder = new StringBuilder();

// stringBuilder.append("SELECT * FROM
// ").append(dbTable.nameOfTable()).append(";");

// // Connection conn = MysqlDb.getInstance().getConnection();
// PreparedStatement preparedStatement =
// connection.prepareStatement(stringBuilder.toString());

// ResultSet resultSet = preparedStatement.executeQuery();

// List<T> result = new ArrayList<>();

// System.out.println("****************************************************************");
// System.out.println("Executing SQL query: " + stringBuilder.toString());
// System.out.println("****************************************************************");

// while (resultSet.next()) {
// T object = (T) clazz.getDeclaredConstructor().newInstance();

// for (Field field : clazz.getDeclaredFields()) {
// DbTableColumn dbColumn = field.getAnnotation(DbTableColumn.class);
// if (dbColumn != null) {
// String columnName = dbColumn.name();

// Object value = resultSet.getObject(columnName);
// field.setAccessible(true);

// // Perform type conversion before setting the field
// Object convertedValue = convertToFieldType(value, field.getType());
// field.set(object, convertedValue);

// //
// System.out.println("****************************************************************");
// System.out.println("Setting " + field.getName() + " to " + convertedValue);

// System.out.println("****************************************************************");

// }
// }

// result.add(object);
// }
// return result;

// } catch (SQLException | InvocationTargetException | InstantiationException |
// IllegalAccessException
// | NoSuchMethodException ex) {
// throw new RuntimeException(ex);
// }
// }

// private static Object convertToFieldType(Object value, Class<?> targetType) {
// if (value == null || targetType.isAssignableFrom(value.getClass())) {
// return value;
// }

// if (targetType == Integer.class || targetType == int.class) {
// return Integer.parseInt(value.toString());
// }
// // Add other type conversions as needed

// return value;
// }

// /**
// * The function deletes a record from a database table based on the provided
// * filter class and ID.
// *
// * @param filter The "filter" parameter is a Class object that represents the
// * type of the entity that
// * needs to be deleted from the database. It is used to retrieve
// * the annotation information from the
// * class.
// * @param id The "id" parameter is of type Long and represents the unique
// * identifier of the record to
// * be deleted from the database table.
// */

// // changed
// public <T> void deleteById(Class<T> filter, Long id) {
// try {
// if (!filter.isAnnotationPresent(DbTable.class)) {
// return;
// }

// DbTable dbTable = filter.getAnnotation(DbTable.class);
// String deleteSQL = "DELETE FROM " + dbTable.nameOfTable() + " WHERE id = ?";

// try (PreparedStatement preparedStatement =
// connection.prepareStatement(deleteSQL)) {
// preparedStatement.setLong(1, id);
// preparedStatement.executeUpdate();
// }
// } catch (SQLException e) {
// throw new RuntimeException(e);
// }
// }

// public Connection getConnection() {
// return connection;
// }

// public void setConnection(Connection connection) {
// this.connection = connection;
// }

// }

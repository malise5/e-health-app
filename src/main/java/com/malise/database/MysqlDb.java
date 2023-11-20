package com.malise.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MysqlDb implements Serializable {

  private static final String URL = "jdbc:mysql://localhost:3306/hospital";

  private static final String USER = "root";

  private static final String PASSWORD = "root";

  private static MysqlDb database;

  private Connection connection;

  private MysqlDb() throws SQLException {

    MysqlDataSource datasource = new MysqlDataSource();
    datasource.setUrl(URL);
    datasource.setUser(USER);
    datasource.setPassword(PASSWORD);

    connection = datasource.getConnection();

  }

  public static MysqlDb getInstance() throws SQLException {
    if (database == null) {
      database = new MysqlDb();

    }

    return database;
  }

  public Connection getConnection() {
    return connection;
  }

  public void setConnection(Connection connection) {
    this.connection = connection;
  }

}

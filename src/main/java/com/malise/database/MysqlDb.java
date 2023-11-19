package com.malise.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDb implements Serializable {

  private static final String URL = "jdbc:mysql://localhost:3306/DbHospital";

  private static final String USER = "root";

  private static final String PASSWORD = "root";

  private static MysqlDb database;

  private Connection connection;

  private MysqlDb() throws SQLException {

    connection = DriverManager.getConnection(URL, USER, PASSWORD);

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

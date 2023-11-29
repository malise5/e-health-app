// package com.malise.event;

// import java.lang.reflect.Field;
// import java.sql.Connection;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// import javax.servlet.ServletContextEvent;
// import javax.servlet.ServletContextListener;
// import javax.servlet.annotation.WebListener;
// import com.malise.database.MysqlDb;

// @WebListener
// public class AppInit implements ServletContextListener {

// @Override
// public void contextInitialized(ServletContextEvent sce) {

// MysqlDb.updateSchema();

// }

// @Override
// public void contextDestroyed(ServletContextEvent sce) {
// System.out.println("Application has been destroyed/undeployed");

// try {
// MysqlDb database = MysqlDb.getInstance();

// if (database.getConnection() != null) {
// database.getConnection().close();
// }
// } catch (SQLException e) {
// e.printStackTrace();
// }
// }

// }

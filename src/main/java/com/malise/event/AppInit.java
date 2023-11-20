package com.malise.event;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.malise.database.MysqlDb;

@WebListener
public class AppInit implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {

    MysqlDb.updateSchema();
    // System.out.println("***********Initializing Database*************");

    // try {
    // Connection conn = MysqlDb.getInstance().getConnection();

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

    // conn.prepareStatement(tableCreationSql).executeUpdate();
    // }
    // } catch (SQLException e) {
    // e.printStackTrace();
    // }

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("Application has been destroyed/undeployed");

    try {
      MysqlDb database = MysqlDb.getInstance();

      if (database.getConnection() != null) {
        database.getConnection().close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}

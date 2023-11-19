package com.malise.event;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.malise.app.model.entity.Apparatus;
import com.malise.app.model.entity.Doctor;
import com.malise.app.model.entity.User;
import com.malise.app.model.entity.Ward;
import com.malise.database.MysqlDb;
import com.malise.database.helper.DbTable;
import com.malise.database.helper.DbTableColumn;

@WebListener
public class AppInit implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("***********Initializing Database*************");

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
        DbTable dbTable = clazz.getAnnotation(DbTable.class);
        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("create table if not exists ").append(dbTable.nameOfTable()).append("(");
        for (Field field : clazz.getDeclaredFields()) {
          if (!field.isAnnotationPresent(DbTableColumn.class)) {
            continue;
          }
          DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);
          sqlBuilder.append(dbTableColumn.name()).append(" ").append(dbTableColumn.defination()).append(",");

        }
        sqlBuilder.append(")");

        conn.prepareStatement(sqlBuilder.toString().replace(",)", ")")).executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

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

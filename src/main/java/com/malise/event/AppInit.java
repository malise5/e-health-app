package com.malise.event;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.malise.app.model.entity.Apparatus;
import com.malise.app.model.entity.Doctor;
import com.malise.app.model.entity.User;
import com.malise.app.model.entity.Ward;
import com.malise.database.Database;

@WebListener
public class AppInit implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("***********Initializing Database*************");

    Database database = Database.getDbInstance();
    database.getData().add(new User(0L, "Malise", "123"));
    database.getData().add(new User(0L, "Abdi", "123"));
    database.getData().add(new User(0L, "Sule", "123"));

    database.getData().add(new Doctor("1", "Halkano Malise", "malise@gmail.com", "Cardiologist"));
    database.getData().add(new Doctor("2", "Mohammed Ali", "moha@gmail.com", "Gynaecologist"));
    database.getData().add(new Doctor("3", "Linus ", "linux@gmail.com", "Denstist"));
    // database.getDoctor().add(new Doctor("4", "Ben Carson", "linux@gmail.com",
    // "Pediatrics"));

    database.getData().add(new Ward("Ward 1", 5, 10));
    database.getData().add(new Ward("Ward 2", 9, 10));
    database.getData().add(new Ward("Ward 3", 9, 10));

    database.getData().add(new Apparatus(1, "Defibrillators", 5));
    database.getData().add(new Apparatus(2, "Gloves", 12));
    database.getData().add(new Apparatus(3, "Weighing Scales", 7));
    // database.getApparatus().add(new Apparatus(4, "Patient Monitors.", 10));

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("Application has been destroyed/undeployed");
  }

}

package com.malise.event;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInit implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("Application has been initualized");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("Application has been destroyed/undeployed");
  }

}

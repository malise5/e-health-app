package com.malise.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Hello implements Servlet {

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public String getServletInfo() {
    return "<h1>Hello Afya</h1>";
  }

  @Override
  public void init(ServletConfig arg0) throws ServletException {
    System.out.println("initialized hello servlet");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    PrintWriter print = res.getWriter();
    print.print(getServletInfo());
  }

  @Override
  public void destroy() {
    System.out.println("Shutting down");
  }

}

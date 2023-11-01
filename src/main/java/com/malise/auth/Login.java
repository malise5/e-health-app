package com.malise.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

  // @Override
  // protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
  // ServletException, IOException {

  // PrintWriter print = resp.getWriter();

  // print.print("");

  // }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String username = req.getParameter("username");
    String password = req.getParameter("password");

    PrintWriter print = resp.getWriter();

    if (username.equals("malise") && password.equals("malise123")) {
      print.println("<h1>Welcome to Afya Nursing Home</h1>");
    } else {
      print.print("<h2>Wrong username and password <a href=\".\">Login again</a></h2>");
    }

  }
}

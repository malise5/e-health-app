package com.malise.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String username = req.getParameter("username");
    String password = req.getParameter("password");

    if (username.equals("malise") && password.equals("malise123")) {

      RequestDispatcher dispatcher = req.getRequestDispatcher("./app/home.html");
      dispatcher.include(req, resp);

    } else {
      PrintWriter print = resp.getWriter();
      print.print("<html><body><h2>Wrong username and password <a href=\".\">Login again</a></h2></body></html>");
    }

  }
}

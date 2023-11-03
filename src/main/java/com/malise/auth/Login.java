package com.malise.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login", initParams = {
    @WebInitParam(name = "username", value = "malise"),
    @WebInitParam(name = "password", value = "malise123"),
})
public class Login extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String username = req.getParameter("username");
    String password = req.getParameter("password");

    if (username.equals(getInitParameter("username")) && password.equals(getInitParameter("password"))) {

      req.setAttribute("homeinfo", "welcome to E-Health Home page");
      RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
      dispatcher.forward(req, resp);

      // ?resp.sendRedirect('./app/home.html') will include the path in the url

    } else {
      PrintWriter print = resp.getWriter();
      print.print("<html><body><h2>Wrong username and password <a href=\".\">Login again</a></h2></body></html>");
    }
  }

}

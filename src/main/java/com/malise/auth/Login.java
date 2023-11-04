package com.malise.auth;

import java.io.IOException;
import java.io.PrintWriter;

// import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession httpSession = req.getSession();

    if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {
      resp.sendRedirect("./home");
    } else {
      resp.sendRedirect("./");
    }

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession httpSession = req.getSession(true);
    httpSession.setAttribute("LoginId", "Admin");

    ServletContext ctx = getServletContext();

    String username = req.getParameter("username");
    String password = req.getParameter("password");

    // if (username.equals(getInitParameter("username")) &&
    // password.equals(getInitParameter("password"))) for servletConfig
    if (username.equals(ctx.getInitParameter("username")) && password.equals(ctx.getInitParameter("password"))) {

      // to access within the web app
      ctx.setAttribute("username", username);

      // RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
      // dispatcher.forward(req, resp);

      resp.sendRedirect("./home");

    } else {
      PrintWriter print = resp.getWriter();
      print.print("<html><body><h2>Wrong username and password</h2>" +
          "<a href=\"create_account.html\">Create New Account</a>" +
          "<br><a href=\".\">Login again</a></body></html>");
    }

  }

}

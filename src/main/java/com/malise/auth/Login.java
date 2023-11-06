package com.malise.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.malise.app.model.entity.User;
import com.malise.database.Database;

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

    String username = req.getParameter("username");
    String password = req.getParameter("password");

    // check if the user exists
    Database database = Database.getDbInstance();

    for (User user : database.getUsers()) {

      if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {

        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("LoginId", "Admin");

        // RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
        // dispatcher.forward(req, resp);

        httpSession.setAttribute("username", username);

        resp.sendRedirect("./home");

      }

    }

    PrintWriter print = resp.getWriter();
    print.print("<html><body><h2>Wrong username and password</h2>" +
        "<br><a href=\".\">Login again</a></body></html>");

  }

}

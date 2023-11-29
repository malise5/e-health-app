/**
 * The LoginAction class is a Java servlet that handles the login functionality for a web application.
 */
package com.malise.app.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.malise.app.bean.AuthBean;
import com.malise.app.bean.AuthBeanI;
import com.malise.app.model.entity.User;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends BaseAction {

  @EJB
  AuthBeanI authBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession httpSession = req.getSession();

    if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {
      resp.sendRedirect("./doctor");
    } else {
      resp.sendRedirect("./");
    }

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    User loginUser = new User();
    serializeForm(loginUser, req.getParameterMap());

    // This code block is responsible for authenticating the user's login
    // credentials.
    User userDetails;
    try {
      userDetails = authBean.authenticate(loginUser);
      if (userDetails != null && StringUtils.isNotEmpty(userDetails.getUsername())) {

        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("LoginId", "Admin");
        httpSession.setAttribute("username", userDetails.getUsername());
        // httpSession.setAttribute("activeMenu", 0);

        // resp.sendRedirect("./home");
        resp.sendRedirect("./doctor");

      }
      RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
      dispatcher.forward(req, resp);
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}

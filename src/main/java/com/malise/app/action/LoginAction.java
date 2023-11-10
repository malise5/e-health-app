package com.malise.app.action;

import java.io.IOException;
import java.io.PrintWriter;

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

  AuthBeanI authBean = new AuthBean();

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

    User loginUser = new User();
    serializeForm(loginUser, req.getParameterMap());

    User userDetails = authBean.authenticate(loginUser);
    if (userDetails != null) {

      HttpSession httpSession = req.getSession(true);
      httpSession.setAttribute("LoginId", "Admin");
      httpSession.setAttribute("username", loginUser.getUsername());
      // httpSession.setAttribute("activeMenu", 0);

      resp.sendRedirect("./home");

    }

    PrintWriter print = resp.getWriter();
    print.print("<html><body><h2>Wrong username and password</h2>" +
        "<br><a href=\".\">Login again</a></body></html>");

  }

}

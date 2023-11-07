package com.malise.app.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.malise.app.model.entity.Doctor;
import com.malise.database.Database;

@WebServlet("/doctor")
public class DoctorAction extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession httpSession = req.getSession();

    if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {

      Database database = Database.getDbInstance();
      database.getDoctor().add(new Doctor(req.getParameter("index"), req.getParameter("name"),
          req.getParameter("email"), req.getParameter("specialization")));

      resp.sendRedirect("./home");
    } else {
      resp.sendRedirect("./");
    }

  }

}

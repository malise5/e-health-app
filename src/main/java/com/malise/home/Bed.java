package com.malise.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.malise.app.view.html.AppPage;

@WebServlet(urlPatterns = "/bed")
public class Bed extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession httpSession = req.getSession();

    if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {
      new AppPage().renderHtml(req, resp, 3, "<header><h1>Bed Information Dashboard</h1></header>");

    } else {
      resp.sendRedirect("./");
    }

  }
}

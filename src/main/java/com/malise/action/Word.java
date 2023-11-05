package com.malise.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.malise.app.view.html.AppPage;

@WebServlet(urlPatterns = "/word")
public class Word extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession httpSession = req.getSession();

    if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {
      new AppPage().renderHtml(req, resp, 2, "<header><h1>word Information Dashboard</h1></header>");

    } else {
      resp.sendRedirect("./");
    }

  }
}

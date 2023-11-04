package com.malise.app.view.html;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.malise.app.view.css.AppCss;
import com.malise.app.view.toolbar.TopToolbar;

public class AppPage implements Serializable {

  public void renderHtml(HttpServletRequest req, HttpServletResponse resp,
      int activeMenu, String content) throws IOException {

    HttpSession session = req.getSession();

    ServletContext ctx = req.getServletContext();

    PrintWriter print = resp.getWriter();

    print.write("<!DOCTYPE html>" +
        "<html>" +

        "<head>" +
        new AppCss().getStyle() +
        "</head>" +

        "<body>" +
        "<nav class=\"navbar\">\n" + //
        " <div class=\"logo\">\n" + //
        "   <h4>Welcome: " + session.getAttribute("username") + "</h4>\n" + //
        " </div>\n" + //

        new TopToolbar().menu(activeMenu) +

        "</nav>");

    print.write(content);
    print.write("<a href=\"./logout\">Logout</a>" +
        "</body>" +
        "</html>");

  }

}

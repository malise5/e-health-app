package com.malise.app.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.malise.app.model.entity.Apparatus;
import com.malise.app.view.html.AppPage;
import com.malise.app.view.html.HtmlComponent;

@WebServlet(urlPatterns = "/apparatus")
public class ApparatusAction extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession httpSession = req.getSession();

    // new AppPage().renderHtml(req, resp, 1, HtmlComponent.form(Ward.class));
    new AppPage().renderHtml(req, resp, 2,
        "<header><h1>Apparatus Information Dashboard</h1></header> <div class=container>" +
            "\n" + //
            "<body>\n" + //
            "\n" + //
            "<button id=\"openModalButton\" onclick=\"openModal()\">Add Ward</button>\n" + //
            "\n" + //
            "<div id=\"myModal\" class=\"modal\">\n" + //
            "    <div class=\"modal-content\">\n" + //
            "        <span class=\"close\" id=\"closeModal\" onclick=\"closeModal()\">&times;</span>\n" + //

            HtmlComponent.form(Apparatus.class) +
            "    </div>\n" + //
            "</div>\n" + //
            "\n" + //
            "<script>\n" +
            "    const modal = document.getElementById(\"myModal\");\n" +
            "    \n" +
            "    function openModal() {\n" +
            "        modal.style.display = \"block\";\n" +
            "        document.addEventListener(\"click\", closeOnClickOutside);\n" +
            "    }\n" +
            "    \n" +
            "    function closeModal() {\n" +
            "        modal.style.display = \"none\";\n" +
            "        document.removeEventListener(\"click\", closeOnClickOutside);\n" +
            "    }\n" +
            "    \n" +
            "    function closeOnClickOutside(event) {\n" +
            "        if (event.target === modal) {\n" +
            "            modal.style.display = \"none\";\n" +
            "            document.removeEventListener(\"click\", closeOnClickOutside);\n" +
            "        }\n" +
            "    }\n" +
            "</script>\n" + //
            "\n" + //
            "</body>"
            // + doctorBean.chartOfDoctors()
            + "</div>");

  }

}

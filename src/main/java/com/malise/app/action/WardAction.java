package com.malise.app.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.malise.app.model.entity.Ward;
import com.malise.app.view.html.HtmlComponent;

@WebServlet(urlPatterns = "/ward")
public class WardAction extends BaseAction {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // HttpSession httpSession = req.getSession();

    renderPage(req, resp, 1, "<header><h1>Doctor Information Dashboard</h1></header> <div class=container>" +
        "<div class=container>" +
        "\n" + //
        "<body>\n" + //
        "\n" + //
        "<button id=\"openModalButton\" onclick=\"openModal()\">Add Doctor</button>\n" + //
        "\n" + //
        "<div id=\"myModal\" class=\"modal\">\n" + //
        "    <div class=\"modal-content\">\n" + //
        "        <span class=\"close\" id=\"closeModal\" onclick=\"closeModal()\">&times;</span>\n" + //
        HtmlComponent.form(Ward.class) +
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
        // + doctorBean.chartOfDoctors() contents go here
        +
        "            <table>\n" + //
        "                <tr>\n" + //
        "                    <th>Name</th>\n" + //
        "                    <th>Capacity</th>\n" + //
        "                    <th>currentOccupancy</th>\n" + ////
        "                </tr>\n" + //
        "                <tr>\n" + //
        "                    <td>ward1</td>\n" + //
        "                    <td>20</td>\n" + //
        "                    <td>8</td>\n" + //
        "                </tr>\n" + //
        "                <tr>\n" + //
        "                    <td>ward2</td>\n" + //
        "                    <td>12</td>\n" + //
        "                    <td>5</td>\n" + ///
        "                </tr>\n" + //
        "            </table>\n"
        // + HtmlComponent.table(new ArrayList<Ward>())
        + "</div>");
  }

}

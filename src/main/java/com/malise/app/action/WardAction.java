package com.malise.app.action;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.malise.app.bean.WardBeanI;
import com.malise.app.model.entity.Ward;
import com.malise.app.view.html.HtmlComponent;

@WebServlet(urlPatterns = "/ward")
public class WardAction extends BaseAction {

  @EJB
  private WardBeanI wardBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String type = StringUtils.trimToEmpty(req.getParameter("type"));
    String mode = StringUtils.trimToEmpty(req.getParameter("mode"));

    if (type.equals("ward") && mode.equals("remove")) {
      if (StringUtils.isNotBlank(req.getParameter("wardID"))) {
        int wardID = Integer.parseInt(req.getParameter("wardID"));

        Ward ward = wardBean.getWardByID(wardID);
        System.out.println("############# Ward Name " + ward.getWardName());

        wardBean.delete(ward);
        try {
          Thread.sleep(2000);

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

    List<Ward> ward = wardBean.getList(new Ward());

    String wardTables = HtmlComponent.table(ward);

    renderPage(req, resp, 2, "<header><h1>Ward Dashboard</h1></header> <div class=container>" +
        "<div class=container>" +
        "\n" + //
        "<body>\n" + //
        "\n" + //
        "<button id=\"openModalButton\" onclick=\"openModal()\">Add Ward</button>\n" + //
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
        // + wardBean.getWardTableHTML()
        + wardTables
        + "</div>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // The code snippet is handling the POST request in the `doPost` method of the
    // `WardAction` class.
    // Here's what it does:
    Ward ward = new Ward();

    serializeForm(ward, req.getParameterMap());

    wardBean.add(ward);

    resp.sendRedirect("./ward");
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // String wardIdToDelete = req.getParameter("wardId");

    // if (wardIdToDelete != null && !wardIdToDelete.isEmpty()) {
    // // Convert wardId to an integer (you might want to add error handling)
    // int wardId = Integer.parseInt(wardIdToDelete);

    // // Create a dummy Ward object with the given wardId
    // Ward wardToDelete = new Ward();
    // wardToDelete.setId(wardId); // Assuming Ward class has a setId method

    // // Perform the delete operation
    // wardBean.delete(wardToDelete);

    // // Redirect back to the ward page
    // resp.sendRedirect("./ward");
    // } else {
    // resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    // resp.getWriter().write("Invalid wardId for deletion");
    // }

  }

}

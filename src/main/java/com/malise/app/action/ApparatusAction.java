package com.malise.app.action;

import java.io.IOException;
// import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

// import com.malise.app.bean.ApparatusBean;
import com.malise.app.bean.ApparatusBeanI;
import com.malise.app.model.entity.Apparatus;
import com.malise.app.view.html.HtmlComponent;

@WebServlet("/apparatus")
public class ApparatusAction extends BaseAction {

  @EJB
  private ApparatusBeanI apparatusBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String type = StringUtils.trimToEmpty(req.getParameter("type"));
    String mode = StringUtils.trimToEmpty(req.getParameter("mode"));
    // PrintWriter printWriter = resp.getWriter();

    if (type.equals("apparatus") && mode.equals("remove")) {
      // get the id that has been passede
      if (StringUtils.isNotBlank(req.getParameter("apparatusID"))) {
        int apparatusID = Integer.parseInt(req.getParameter("apparatusID"));
        // remove by the id
        // get the product by ID
        Apparatus apparatus = apparatusBean.getApparatusByID(apparatusID);
        System.out.println("############## Apparatus Name " + apparatus.getApparatusName());

        apparatusBean.delete(apparatus);
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

    List<Apparatus> apparatus = apparatusBean.getList(new Apparatus());

    String apparatusTables = HtmlComponent.table(apparatus);

    // HttpSession httpSession = req.getSession();

    renderPage(req, resp, 3, "<header><h1>Apparatus Information Dashboard</h1></header> <div class=container>" +
        "<div class=container>" +
        "\n" + //
        "<body>\n" + //
        "\n" + //
        "<button id=\"openModalButton\" onclick=\"openModal()\">Add Apparatus</button>\n" + //
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
        // + apparatusBean.getApparatusTableHTML()
        + apparatusTables
        + "</div>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Apparatus apparatus = new Apparatus();

    serializeForm(apparatus, req.getParameterMap());

    apparatusBean.add(apparatus);

    resp.sendRedirect("./apparatus");
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

}

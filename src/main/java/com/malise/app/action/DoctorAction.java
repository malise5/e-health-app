package com.malise.app.action;

import java.io.IOException;
// import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import org.apache.commons.beanutils.BeanUtils;
// import org.apache.commons.lang3.StringUtils;

import com.malise.app.bean.DoctorBean;
import com.malise.app.bean.DoctorBeanI;
import com.malise.app.model.entity.Doctor;
import com.malise.app.view.html.HtmlComponent;

@WebServlet("/doctor")
public class DoctorAction extends BaseAction {

  private final DoctorBeanI doctorBean = new DoctorBean();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    List<Doctor> doctors = doctorBean.getList(Doctor.class);

    String doctorTables = HtmlComponent.table(doctors);

    // from base action
    renderPage(req, resp, 0, "<header><h1>Doctor Information Dashboard</h1></header> <div class=container>" +
        "<div class=container>" +
        "\n" + //
        "<body>\n" + //
        "\n" + //
        "<button id=\"openModalButton\" onclick=\"openModal()\">Add Doctor</button>\n" + //
        "\n" + //
        "<div id=\"myModal\" class=\"modal\">\n" + //
        "    <div class=\"modal-content\">\n" + //
        "        <span class=\"close\" id=\"closeModal\" onclick=\"closeModal()\">&times;</span>\n" + //
        HtmlComponent.form(Doctor.class) +
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
        // + doctorBean.getDoctorTableHTML()
        + doctorTables
        + "</div>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Doctor doctor = new Doctor();

    DoctorBeanI doctorBean = new DoctorBean();

    serializeForm(doctor, req.getParameterMap());

    doctorBean.add(doctor);

    resp.sendRedirect("./doctor");

  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

}

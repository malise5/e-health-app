package com.malise.app.action;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
// import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.malise.app.bean.PatientBeanI;
import com.malise.app.model.entity.Patient;
import com.malise.app.view.html.HtmlComponent;

@WebServlet("/patient")
public class PatientAction extends BaseAction {

  @EJB
  PatientBeanI patientBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String type = StringUtils.trimToEmpty(req.getParameter("type"));
    String mode = StringUtils.trimToEmpty(req.getParameter("mode"));
    // PrintWriter printWriter = resp.getWriter();

    if (type.equals("patient") && mode.equals("remove")) {
      // get the id that has been passede
      if (StringUtils.isNotBlank(req.getParameter("patientID"))) {
        int patientID = Integer.parseInt(req.getParameter("patientID"));
        // remove by the id
        // get the product by ID
        Patient patient = patientBean.getPatientID(patientID);
        System.out.println("############## Patient Name " + patient.getName());

        patientBean.delete(patient);
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

    List<Patient> patients = patientBean.getList(new Patient());

    String patientTable = HtmlComponent.table(patients);

    renderPage(req, resp, 1, "<header><h1>Patient Information Dashboard</h1></header> <div class=container>" +
        "<div class=container>" +
        "\n" + //
        "<body>\n" + //
        "\n" + //
        "<button id=\"openModalButton\" onclick=\"openModal()\">Add Patient</button>\n" + //
        "\n" + //
        "<div id=\"myModal\" class=\"modal\">\n" + //
        "    <div class=\"modal-content\">\n" + //
        "        <span class=\"close\" id=\"closeModal\" onclick=\"closeModal()\">&times;</span>\n" + //
        HtmlComponent.form(Patient.class) +
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
        + patientTable
        + "</div>");

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Patient patient = new Patient();

    serializeForm(patient, req.getParameterMap());

    patientBean.add(patient);

    resp.sendRedirect("./patient");

  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Patient patient = new Patient();

    patientBean.delete(patient);

    resp.sendRedirect("./patient");

  }

}

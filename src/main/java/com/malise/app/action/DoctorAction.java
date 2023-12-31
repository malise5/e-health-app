/**
 * The DoctorAction class is a Java servlet that handles HTTP requests related to doctors, including
 * displaying a list of doctors, adding a new doctor, and deleting a doctor.
 */
package com.malise.app.action;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import com.malise.app.bean.DoctorBeanI;
import com.malise.app.model.entity.Doctor;
import com.malise.app.view.html.HtmlComponent;

@WebServlet("/doctor")
public class DoctorAction extends BaseAction {

  // private final DoctorBeanI doctorBean = new DoctorBean();
  @EJB
  DoctorBeanI doctorBean;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String type = StringUtils.trimToEmpty(req.getParameter("type"));
    String mode = StringUtils.trimToEmpty(req.getParameter("mode"));
    // PrintWriter printWriter = resp.getWriter();

    if (type.equals("doctor") && mode.equals("remove")) {
      // get the id that has been passede
      if (StringUtils.isNotBlank(req.getParameter("doctorID"))) {
        int doctorID = Integer.parseInt(req.getParameter("doctorID"));
        // remove by the id
        // get the product by ID
        Doctor doctor = doctorBean.getDoctorById(doctorID);
        System.out.println("############## Doctor Name " + doctor.getName());

        doctorBean.delete(doctor);
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

    List<Doctor> doctors = doctorBean.getList(new Doctor());

    String doctorTables = HtmlComponent.table(doctors);

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

  /**
   * The doPost function receives a request, creates a Doctor object, serializes
   * the form data into the
   * Doctor object, adds the Doctor object to a DoctorBean, and then redirects the
   * response to the
   * doctor page.
   * 
   * @param req  The "req" parameter is an instance of the HttpServletRequest
   *             class, which represents the
   *             request made by the client to the server. It contains information
   *             such as the request method,
   *             request headers, request parameters, and the request body.
   * @param resp The "resp" parameter is an instance of the HttpServletResponse
   *             class, which represents
   *             the response that will be sent back to the client. It is used to
   *             send the response back to the
   *             client, in this case, by redirecting the client to the "./doctor"
   *             URL.
   */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Doctor doctor = new Doctor();

    serializeForm(doctor, req.getParameterMap());
    // int Id = Integer.parseInt(req.getParameter())

    doctorBean.add(doctor);

    resp.sendRedirect("./doctor");

  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Doctor doctor = new Doctor();

    doctorBean.delete(doctor);

    resp.sendRedirect("./doctor");

  }

}

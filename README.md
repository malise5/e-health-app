## HOMEACTION

package com.malise.app.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.malise.app.bean.DoctorBean;
import com.malise.app.bean.DoctorBeanI;
import com.malise.app.model.entity.Doctor;
import com.malise.app.view.html.AppPage;
import com.malise.app.view.html.HtmlComponent;

@WebServlet("/home")
public class HomeAction extends HttpServlet {

DoctorBeanI doctorBean = new DoctorBean();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession httpSession = req.getSession();

    // if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {

    new AppPage().renderHtml(req, resp, 0,
        "<header><h1>Doctor Information Dashboard</h1></header> <div class=container>" +
            "<div class=container>" +
            "\n" + //
            "<body>\n" + //
            "\n" + //
            "<button id=\"openModalButton\" onclick=\"openModal()\">Add Doctor</button>\n" + //
            "\n" + //
            "<div id=\"myModal\" class=\"modal\">\n" + //
            "    <div class=\"modal-content\">\n" + //
            "        <span class=\"close\" id=\"closeModal\" onclick=\"closeModal()\">&times;</span>\n" + //
            // " <form action=\"./doctor\" method=\"post\">\n" + //
            // " <label for=\"index\"><b>Index</b></label>\n" + //
            // " <input type=\"text\" placeholder=\"Enter Index\" name=\"index\"
            // required>\n" + //
            // "\n" + //
            // " <label for=\"name\"><b>Name of the Doctor</b></label>\n" + //
            // " <input type=\"text\" id=\"name\" placeholder=\"Enter Name\" name=\"name\"
            // required>\n" + //
            // "\n" + //
            // " <label for=\"email\"><b>Email</b></label>\n" + //
            // " <input type=\"text\" id=\"email\" placeholder=\"Enter Email\"
            // name=\"email\" required>\n" + //
            // "\n" + //
            // " <label for=\"specialization\"><b>Specialization</b></label>\n" + //
            // " <input type=\"text\" placeholder=\"Enter Specialization\"
            // name=\"specialization\" required>\n"
            // + //
            // "\n" + //
            // " <button type=\"submit\">Add Doctor</button>\n" + //
            // " </form>\n" + //
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
            + doctorBean.chartOfDoctors()
            + "</div>");

    // PrintWriter print = resp.getWriter();

    // print.write("<!DOCTYPE html>\n" + //
    // "<html>\n" + //
    // " <head>\n" + //
    // " <title>Hospital Information Dashboard</title>\n" + //
    // " <style>\n" + //
    // " body {\n" + //
    // " font-family: Arial, sans-serif;\n" + //
    // " background-color: #f3f3f3;\n" + //
    // " margin: 0;\n" + //
    // " padding: 0;\n" + //
    // " }\n" + //
    // "\n" + //
    // " .navbar {\n" + //
    // " display: flex;\n" + //
    // " justify-content: space-between;\n" + //
    // " align-items: center;\n" + //
    // " background-color: #3498db;\n" + //
    // " padding: 10px 20px;\n" + //
    // " }\n" + //
    // "\n" + //
    // " \n" + //
    // " .logo img {\n" + //
    // " height: 40px; /* Logo height */\n" + //
    // " }\n" + //
    // "\n" + //
    // " /* Style the navigation links */\n" + //
    // " .nav-links {\n" + //
    // " list-style: none;\n" + //
    // " padding: 0;\n" + //
    // " margin: 0;\n" + //
    // " }\n" + //
    // "\n" + //
    // " .nav-links li {\n" + //
    // " display: inline;\n" + //
    // " margin-right: 15px; /* Spacing between links */\n" + //
    // " }\n" + //
    // "\n" + //
    // " .nav-links a {\n" + //
    // " text-decoration: none;\n" + //
    // " color: #fff; /* Link color */\n" + //
    // " font-weight: bold;\n" + //
    // " }\n" + //
    // "\n" + //
    // " .nav-links a:hover {\n" + //
    // " color: #ff9900; \n" + //
    // " }" +
    // ".nav-links a.active {\n" + //
    // " color: #ff9900; /* Active link color */\n" + //
    // " }" +
    // "\n" + //
    // " header {\n" + //
    // " background-color: #3498db;\n" + //
    // " color: #fff;\n" + //
    // " text-align: center;\n" + //
    // " margin: 20px;\n" + //
    // " padding: 5px 0;\n" + //
    // " }\n" + //
    // "\n" + //
    // " h1 {\n" + //
    // " font-size: 24px;\n" + //
    // " }\n" + //
    // "\n" + //
    // " .container {\n" + //
    // " max-width: 800px;\n" + //
    // " margin: 20px auto;\n" + //
    // " padding: 20px;\n" + //
    // " background-color: #fff;\n" + //
    // " border-radius: 5px;\n" + //
    // " box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" + //
    // " }\n" + //
    // "\n" + //
    // " table {\n" + //
    // " width: 100%;\n" + //
    // " border-collapse: collapse;\n" + //
    // " margin-top: 20px;\n" + //
    // " }\n" + //
    // "\n" + //
    // " th,\n" + //
    // " td {\n" + //
    // " padding: 12px 15px;\n" + //
    // " text-align: left;\n" + //
    // " }\n" + //
    // "\n" + //
    // " th {\n" + //
    // " background-color: #3498db;\n" + //
    // " color: #fff;\n" + //
    // " }\n" + //
    // "\n" + //
    // " tr:nth-child(even) {\n" + //
    // " background-color: #f2f2f2;\n" + //
    // " }\n" + //
    // "\n" + //
    // " tr:nth-child(odd) {\n" + //
    // " background-color: #e6e6e6;\n" + //
    // " }\n" + //
    // " </style>\n" + //
    // " </head>\n" + //
    // " <body>\n" +
    // "<nav class=\"navbar\">\n" + //
    // " <div class=\"logo\">\n" + //
    // " <h4>User " + ctx.getAttribute("username") + "</h4>\n" + //
    // " </div>\n" + //
    // " <ul class=\"nav-links\">\n" + //
    // " <li><a class=\"active\" href=\"./home\">Home</a></li>\n" + //
    // " <li><a href=\"./staff\">Staff</a></li>\n" + //
    // " <li><a href=\"#\">Word</a></li>\n" + //
    // " <li><a href=\"#\">Bed</a></li>\n" + //
    // " </ul>\n" + //
    // " </nav>" +
    // "<div><a href=\"./logout\" >Logout</a></div>\n" + //
    // " <header>\n" + //
    // " <h1>Doctor Information Dashboard</h1>\n" + //
    // " </header>\n" + //
    // "\n" + //
    // " <div class=\"container\">\n");
    // print.write(doctorBean.chartOfDoctors());
    // print.write("\n" + //
    // " </div>\n" + //
    // " </body>\n" + //
    // "</html>\n" + //
    // "");

    // } else {
    // resp.sendRedirect("./");
    // }

}

}

## LOGIN-ACTION

package com.malise.app.action;

import java.io.IOException;
import java.io.PrintWriter;

// import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.malise.app.bean.AuthBean;
import com.malise.app.bean.AuthBeanI;
import com.malise.app.model.entity.User;

@WebServlet(urlPatterns = "/login")
public class LoginAction extends BaseAction {
// public class LoginAction extends HttpServlet {

AuthBeanI authBean = new AuthBean();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession httpSession = req.getSession();

    if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {
      resp.sendRedirect("./home");
    } else {
      resp.sendRedirect("./");
    }

}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    User loginUser = new User();
    serializeForm(loginUser, req.getParameterMap());

    // String username = req.getParameter("username");
    // String password = req.getParameter("password");

    // check if the user exists
    // Database database = Database.getDbInstance();

    User userDetails = authBean.authenticate(loginUser);

    // for (User user : database.getUsers()) {

    // if (username.equals(user.getUsername()) &&
    // password.equals(user.getPassword())) {
    if (userDetails != null) {

      HttpSession httpSession = req.getSession(true);
      httpSession.setAttribute("LoginId", "Admin");

      // RequestDispatcher dispatcher = req.getRequestDispatcher("./home");
      // dispatcher.forward(req, resp);

      // httpSession.setAttribute("username", username);
      httpSession.setAttribute("username", loginUser.getUsername());
      httpSession.setAttribute("activeMenu", 0);

      resp.sendRedirect("./home");

    }

    // }

    PrintWriter print = resp.getWriter();
    print.print("<html><body><h2>Wrong username and password</h2>" +
        "<br><a href=\".\">Login again</a></body></html>");

}

}

## HtmlComponent

package com.malise.app.view.html;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class HtmlComponent implements Serializable {

public static String table(List<? extends Object> models) {

    if (models == null || models.isEmpty()) {
      return StringUtils.EMPTY;
    }

    Field[] fields = models.get(0).getClass().getDeclaredFields();

    StringBuilder trBuilder = new StringBuilder();
    trBuilder.append("<table>");

    trBuilder.append("<tr>");
    for (Field field : fields) {
      if (!field.isAnnotationPresent(AnnoTableHeader.class)) {
        continue;
      }

      // trBuilder.append("<th>" + field.getName() + "</th>");
      trBuilder.append("<th>" + field.getAnnotation(AnnoTableHeader.class).header() + "</th>");
    }
    trBuilder.append("</tr>");

    for (Object model : models) {

      trBuilder.append("<tr>");

      for (Field field : fields) {
        if (!field.isAnnotationPresent(AnnoTableHeader.class)) {
          continue;
        }
        try {
          field.setAccessible(true);
          trBuilder.append("<td>").append(field.get(model).toString()).append("</td>");
        } catch (IllegalArgumentException | IllegalAccessException e) {
          e.printStackTrace();
        }
        // trBuilder.append("<td>").append(StringUtils.trimToEmpty(getName())).append("</td>");
        // trBuilder.append("<td>").append(StringUtils.trimToEmpty(getEmail())).append("</td>");
        // trBuilder.append("<td>").append(StringUtils.trimToEmpty(getSpecialization())).append("</td>");

      }
      trBuilder.append("</tr");
      trBuilder.append("<br/>");

    }

    trBuilder.append("</table>");
    return trBuilder.toString();

}

public static String form(Class<?> model) {

    AnnoHtmlForm formsHtml = null;

    if (model.isAnnotationPresent(AnnoHtmlForm.class))
      formsHtml = model.getAnnotation(AnnoHtmlForm.class);

    if (formsHtml == null)
      return StringUtils.EMPTY;

    String htmlForm = "<header><h1>" + " Add" + formsHtml.label() + "</h1></header> "
        + "<br/>Add" + formsHtml.label() + "<br/><form action=\"" + formsHtml.url() + "\" method=\""
        + formsHtml.Methodhttp() + "\">\n";
    // String htmlForm = "<br/>Add Doctor<br/><form action=\"./doctor\"
    // method=\"post\">\n";

    Field[] fields = model.getDeclaredFields();

    for (Field field : fields) {
      if (!field.isAnnotationPresent(AnnoHtmlFormField.class)) {
        continue;
      }

      AnnoHtmlFormField formField = field.getAnnotation(AnnoHtmlFormField.class);

      String fieldName = field.getName();

      // htmlForm += "<label for=\"" + fieldName + "\"><b>" + fieldName +
      // "</b></label><br/>";
      // htmlForm += " <input type=\"text\" id=\"" + fieldName + "\"
      // placeholder=\"Type here\" name=\"" + fieldName
      // + "\">\n";
      htmlForm += "<label for=\"" + (StringUtils.isBlank(formField.labelFor()) ? fieldName
          : formField.labelFor()) + "\"><b>"
          + (StringUtils.isBlank(formField.label()) ? fieldName
              : formField.label())
          + "</b></label><br/>";
      htmlForm += " <input type=\"text\" id=\"" + (StringUtils.isBlank(formField.idTag()) ? fieldName
          : formField.idTag()) + "\" placeholder=\"Type here\" name=\""
          + (StringUtils.isBlank(formField.name()) ? fieldName
              : formField.name())
          + "\">\n";

    }

    htmlForm += "<button type=\"submit\">Add Doctor</button>\n";
    htmlForm += " </form>\n";//

    return htmlForm;

    // "\n" + //
    // " <label for=\"name\"><b>Name of the Doctor</b></label>\n" + //
    // " <input type=\"text\" id=\"name\" placeholder=\"Enter Name\" name=\"name\"
    // required>\n" + //
    // "\n" + //
    // " <label for=\"email\"><b>Email</b></label>\n" + //
    // " <input type=\"text\" id=\"email\" placeholder=\"Enter Email\"
    // name=\"email\" required>\n" + //
    // "\n" + //
    // " <label for=\"specialization\"><b>Specialization</b></label>\n" + //
    // " <input type=\"text\" placeholder=\"Enter Specialization\"
    // name=\"specialization\" required>\n"
    // + //
    // "\n" + //

}

}

## App-index.jsp

<%@ page import="com.malise.app.view.toolbar.TopToolbar" %>

<!DOCTYPE html>
<html>
    <head>
      <style>
        /* General styles for the body */
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 0;
        }

        /* Styles for the navigation bar */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #3498db;
            padding: 10px 20px;
        }

        .logo img {
            height: 40px; /* Logo height */
        }

        /* Style the navigation links */
        .nav-links {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .nav-links li {
            display: inline;
            margin-right: 15px; /* Spacing between links */
        }

        .nav-links a {
            text-decoration: none;
            color: #fff; /* Link color */
            font-weight: bold;
        }

        .nav-links a:hover {
            color: #ff9900;
        }

        .nav-links a.active {
            color: #ff9900; /* Active link color */
        }

        /* Styles for the header section */
        header {
            background-color: #3498db;
            color: #fff;
            text-align: center;
            margin-top: 10px;
            padding: 5px 0;
        }

        h1 {
            font-size: 24px;
        }

        /* Styles for the container */
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        /* Styles for the table */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th,
        td {
            padding: 12px 15px;
            text-align: left;
        }

        th {
            background-color: #3498db;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:nth-child(odd) {
            background-color: #e6e6e6;
        }

        /* Styles for the modal and form */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: auto;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.7);
        }

        .modal-content {
            background-color: #f4f4f4;
            margin: 10% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 30%;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        }

        .close {
            position: absolute;
            right: 10px;
            top: 10px;
            font-size: 20px;
            font-weight: bold;
            cursor: pointer;
        }

        /* Styles for the form inside the modal */
        form {
            text-align: center;
        }

        label {
            display: block;
            font-weight: bold;
            margin-top: 10px;
        }

        input {
            width: 90%;
            padding: 10px;
            margin: 5px 20px;
        }

        button {
            background-color: #0074cc;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }

        .close:hover {
            color: red;
        }
      </style>
    </head>
    <body>
        <nav class="navbar">
            <div class="logo">
            <h2>Welcome: <%= session.getAttribute("username") %> </h2>
              <p>Authenticated at: <%= response.getHeader("AuthTime") %></p>
            </div>
            <%= new TopToolbar().menu((int)request.getAttribute("activeMenu")) %>
        </nav>
        <%-- <%= request.getAttribute("content") %> --%>

        <div class="container">
          <%-- <button id="openModalButton" onclick="openModal()">Add Doctor</button> --%>
          <div id="myModal" class="modal">
              <div class="modal-content">
                  <span class="close" id="closeModal" onclick="closeModal()">&times;</span>
                  <%-- <!-- Your form or HtmlComponent.form(Doctor.class) goes here --> --%>
                  <%= request.getAttribute("form") %>

              </div>
          </div>

          <%-- <!-- Your table content goes here --> --%>
        <%= request.getAttribute("bean") %>
        </div>



      <a href="./logout">Logout</a>




       <%-- <!-- Your HTML content goes here --> --%>

      <script>
          const modal = document.getElementById("myModal");

          function openModal() {
              modal.style.display = "block";
              document.addEventListener("click", closeOnClickOutside);
          }

          function closeModal() {
              modal.style.display = "none";
              document.removeEventListener("click", closeOnClickOutside);
          }

          function closeOnClickOutside(event) {
              if (event.target === modal) {
                  modal.style.display = "none";
                  document.removeEventListener("click", closeOnClickOutside);
              }
          }
      </script>
    </body>

</html>

## Ward-action

// req.setAttribute("activeMenu", 1);

    // req.setAttribute("content", "<header><h1>Doctor Information
    // Dashboard</h1></header> <div class=container>" +
    // "<div class=container>" +
    // "\n" + //
    // "<body>\n" + //
    // "\n" + //
    // "<button id=\"openModalButton\" onclick=\"openModal()\">Add
    // Doctor</button>\n" + //
    // "\n" + //
    // "<div id=\"myModal\" class=\"modal\">\n" + //
    // " <div class=\"modal-content\">\n" + //
    // " <span class=\"close\" id=\"closeModal\"
    // onclick=\"closeModal()\">&times;</span>\n" + //
    // HtmlComponent.form(Ward.class) +
    // " </div>\n" + //
    // "</div>\n" + //
    // "\n" + //
    // "<script>\n" +
    // " const modal = document.getElementById(\"myModal\");\n" +
    // " \n" +
    // " function openModal() {\n" +
    // " modal.style.display = \"block\";\n" +
    // " document.addEventListener(\"click\", closeOnClickOutside);\n" +
    // " }\n" +
    // " \n" +
    // " function closeModal() {\n" +
    // " modal.style.display = \"none\";\n" +
    // " document.removeEventListener(\"click\", closeOnClickOutside);\n" +
    // " }\n" +
    // " \n" +
    // " function closeOnClickOutside(event) {\n" +
    // " if (event.target === modal) {\n" +
    // " modal.style.display = \"none\";\n" +
    // " document.removeEventListener(\"click\", closeOnClickOutside);\n" +
    // " }\n" +
    // " }\n" +
    // "</script>\n" + //
    // "\n" + //
    // "</body>"
    // // + doctorBean.chartOfDoctors() contents go here
    // + "</div>");

    // RequestDispatcher dispatcher = req.getRequestDispatcher("./app/index.jsp");
    // dispatcher.forward(req, resp);

## pparatus-action

// req.setAttribute("activeMenu", 2);

    // req.setAttribute("content", "<header><h1>Apparatus Information
    // Dashboard</h1></header> <div class=container>" +
    // "<div class=container>" +
    // "\n" + //
    // "<body>\n" + //
    // "\n" + //
    // "<button id=\"openModalButton\" onclick=\"openModal()\">Add
    // Doctor</button>\n" + //
    // "\n" + //
    // "<div id=\"myModal\" class=\"modal\">\n" + //
    // " <div class=\"modal-content\">\n" + //
    // " <span class=\"close\" id=\"closeModal\"
    // onclick=\"closeModal()\">&times;</span>\n" + //
    // HtmlComponent.form(Apparatus.class) +
    // " </div>\n" + //
    // "</div>\n" + //
    // "\n" + //
    // "<script>\n" +
    // " const modal = document.getElementById(\"myModal\");\n" +
    // " \n" +
    // " function openModal() {\n" +
    // " modal.style.display = \"block\";\n" +
    // " document.addEventListener(\"click\", closeOnClickOutside);\n" +
    // " }\n" +
    // " \n" +
    // " function closeModal() {\n" +
    // " modal.style.display = \"none\";\n" +
    // " document.removeEventListener(\"click\", closeOnClickOutside);\n" +
    // " }\n" +
    // " \n" +
    // " function closeOnClickOutside(event) {\n" +
    // " if (event.target === modal) {\n" +
    // " modal.style.display = \"none\";\n" +
    // " document.removeEventListener(\"click\", closeOnClickOutside);\n" +
    // " }\n" +
    // " }\n" +
    // "</script>\n" + //
    // "\n" + //
    // "</body>"
    // // + doctorBean.chartOfDoctors() content goes here
    // + "</div>");

    // RequestDispatcher dispatcher = req.getRequestDispatcher("./app/index.jsp");
    // dispatcher.forward(req, resp);

## HOME-ACTION

    // req.setAttribute("activeMenu", 0);

    // req.setAttribute("content", "<header><h1>Doctor Information
    // Dashboard</h1></header> <div class=container>" +
    // "<div class=container>" +
    // "\n" + //
    // "<body>\n" + //
    // "\n" + //
    // "<button id=\"openModalButton\" onclick=\"openModal()\">Add
    // Doctor</button>\n" + //
    // "\n" + //
    // "<div id=\"myModal\" class=\"modal\">\n" + //
    // " <div class=\"modal-content\">\n" + //
    // " <span class=\"close\" id=\"closeModal\"
    // onclick=\"closeModal()\">&times;</span>\n" + //
    // HtmlComponent.form(Doctor.class) +
    // " </div>\n" + //
    // "</div>\n" + //
    // "\n" + //
    // "<script>\n" +
    // " const modal = document.getElementById(\"myModal\");\n" +
    // " \n" +
    // " function openModal() {\n" +
    // " modal.style.display = \"block\";\n" +
    // " document.addEventListener(\"click\", closeOnClickOutside);\n" +
    // " }\n" +
    // " \n" +
    // " function closeModal() {\n" +
    // " modal.style.display = \"none\";\n" +
    // " document.removeEventListener(\"click\", closeOnClickOutside);\n" +
    // " }\n" +
    // " \n" +
    // " function closeOnClickOutside(event) {\n" +
    // " if (event.target === modal) {\n" +
    // " modal.style.display = \"none\";\n" +
    // " document.removeEventListener(\"click\", closeOnClickOutside);\n" +
    // " }\n" +
    // " }\n" +
    // "</script>\n" + //
    // "\n" + //
    // "</body>"
    // + doctorBean.chartOfDoctors()
    // + "</div>");

    // RequestDispatcher dispatcher = req.getRequestDispatcher("./app/index.jsp");
    // dispatcher.forward(req, resp);

    // new AppPage().renderHtml(req, resp, 0);

## app/index.jsp

<%@ page isELIgnored="false"%>
<%@ page import="com.malise.app.view.toolbar.TopToolbar" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../style/style.jsp" />
    </head>
    <body>
        <nav class="navbar">
            <div class="logo">
            <%-- <h3>Welcome: <%= session.getAttribute("username") %> </h3> --%>
            <h3>Welcome: ${session.username}</h3>
              <%= response.getHeader("AuthTime") %>
            </div>
            <jsp:useBean id="navBar" class="com.malise.app.view.toolbar" />
            <jsp:setProperty name="navBar" property="activeLink"  value="<%=request.getAttribute("activeMenu")%>/>
            <jsp:getProperty name="navBar" property="menu" />
            <%= new TopToolbar().menu((int)request.getAttribute("activeMenu")) %>
        </nav>
        <%= request.getAttribute("content") %>
        
      <a href="./logout">Logout</a>
    </body>
</html>

part 2

<%@ page isELIgnored="false"%>
<%@ page import="com.malise.app.view.toolbar.TopToolbar" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../style/style.jsp" />
    </head>
    <body>
        <nav class="navbar">
            <div class="logo">
            <%-- <h3>Welcome: <%= session.getAttribute("username") %> </h3> --%>
            <h3>Welcome: ${session.username}</h3>
              <%= response.getHeader("AuthTime") %>
            </div>
            <jsp:useBean id="navBar" class="com.malise.app.view.toolbar.TopToolbar" />
            <jsp:setProperty name="navBar" property="activeLink"  value='<%=request.getAttribute("activeMenu")%>'/>
            <jsp:getProperty name="navBar" property="menu" />
        </nav>
        ${request.content} %>
        
      <a href="./logout">Logout</a>
    </body>
</html>

## Doctor action

package com.malise.app.action;

import java.io.IOException;
// import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// import org.apache.commons.beanutils.BeanUtils;
// import org.apache.commons.lang3.StringUtils;

import com.malise.app.bean.DoctorBean;
import com.malise.app.bean.DoctorBeanI;
import com.malise.app.model.entity.Doctor;

@WebServlet("/doctor")
public class DoctorAction extends BaseAction {

// private Doctor doctor = new Doctor();

// private DoctorBeanI doctorBean = new DoctorBean();

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// HttpSession httpSession = req.getSession();

    // if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {

    // Database database = Database.getDbInstance();
    // database.getDoctor().add(new Doctor(req.getParameter("index"),
    // req.getParameter("name"),
    // req.getParameter("email"), req.getParameter("specialization")));
    Doctor doctor = new Doctor();

    DoctorBeanI doctorBean = new DoctorBean();

    serializeForm(doctor, req.getParameterMap());

    doctorBean.addDoctors(doctor);

    // doctorBean.addDoctors(new Doctor(req.getParameter("index"),
    // req.getParameter("name"), req.getParameter("email"),
    // req.getParameter("specialization")));

    resp.sendRedirect("./home");

    // } else {
    // resp.sendRedirect("./");
    // }

}

}

package com.malise.action;

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
import com.malise.app.view.html.AppPage;

@WebServlet("/home")
public class Home extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession httpSession = req.getSession();

    if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {

      DoctorBeanI doctorBean = new DoctorBean();

      new AppPage().renderHtml(req, resp, 0,
          "<header><h1>Doctor Information Dashboard</h1></header> <div class=container>" +
          // "<h2>Add Doctor</h2>\n" + //
              "\n" + //
              "<head>\n" + //
              "    <style>\n" + //
              "        /* Styles for the modal and form */\n" + //
              "        .modal {\n" + //
              "            display: none;\n" + //
              "            position: fixed;\n" + //
              "            z-index: 1;\n" + //
              "            left: 0;\n" + //
              "            top: 0;\n" + //
              "            width: 100%;\n" + //
              "            height: 100%;\n" + //
              "            overflow: auto;\n" + //
              "            background-color: rgba(0, 0, 0, 0.7);\n" + //
              "        }\n" + //
              "\n" + //
              "        .modal-content {\n" + //
              "            background-color: #f4f4f4;\n" + //
              "            margin: 15% auto;\n" + //
              "            padding: 20px;\n" + //
              "            border: 1px solid #888;\n" + //
              "            width: 50%;\n" + //
              "            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\n" + //
              "        }\n" + //
              "\n" + //
              "        .close {\n" + //
              "            position: absolute;\n" + //
              "            right: 10px;\n" + //
              "            top: 10px;\n" + //
              "            font-size: 20px;\n" + //
              "            font-weight: bold;\n" + //
              "            cursor: pointer;\n" + //
              "        }\n" + //
              "\n" + //
              "        form {\n" + //
              "            text-align: center;\n" + //
              "        }\n" + //
              "\n" + //
              "        label {\n" + //
              "            display: block;\n" + //
              "            font-weight: bold;\n" + //
              "            margin-top: 10px;\n" + //
              "        }\n" + //
              "\n" + //
              "        input {\n" + //
              "            width: 80%;\n" + //
              "            padding: 10px;\n" + //
              "            margin: 5px 20px;\n" + //
              "        }\n" + //
              "\n" + //
              "        button {\n" + //
              "            background-color: #0074cc;\n" + //
              "            color: #fff;\n" + //
              "            padding: 10px 20px;\n" + //
              "            border: none;\n" + //
              "            cursor: pointer;\n" + //
              "        }\n" + //
              "\n" + //
              "        .close:hover {\n" + //
              "            color: red;\n" + //
              "        }\n" + //
              "    </style>\n" + //
              "</head>\n" + //
              "<body>\n" + //
              "\n" + //
              "<button id=\"openModalButton\" onclick=\"openModal()\">Add Doctor</button>\n" + //
              "\n" + //
              "<div id=\"myModal\" class=\"modal\">\n" + //
              "    <div class=\"modal-content\">\n" + //
              "        <span class=\"close\" id=\"closeModal\" onclick=\"closeModal()\">&times;</span>\n" + //
              "        <form action=\"./doctor\" method=\"post\">\n" + //
              "            <label for=\"index\"><b>Index</b></label>\n" + //
              "            <input type=\"text\" placeholder=\"Enter Index\" name=\"index\" required>\n" + //
              "\n" + //
              "            <label for=\"name\"><b>Name of the Doctor</b></label>\n" + //
              "            <input type=\"text\" id=\"name\" placeholder=\"Enter Name\" name=\"name\" required>\n" + //
              "\n" + //
              "            <label for=\"email\"><b>Email</b></label>\n" + //
              "            <input type=\"text\" id=\"email\" placeholder=\"Enter Email\" name=\"email\" required>\n" + //
              "\n" + //
              "            <label for=\"specialization\"><b>Specialization</b></label>\n" + //
              "            <input type=\"text\" placeholder=\"Enter Specialization\" name=\"specialization\" required>\n"
              + //
              "\n" + //
              "            <button type=\"submit\">Add Doctor</button>\n" + //
              "        </form>\n" + //
              "    </div>\n" + //
              "</div>\n" + //
              "\n" + //
              "<script>\n" + //
              "    function openModal() {\n" + //
              "        document.getElementById(\"myModal\").style.display = \"block\";\n" + //
              "    }\n" + //
              "\n" + //
              "    function closeModal() {\n" + //
              "        document.getElementById(\"myModal\").style.display = \"none\";\n" + //
              "    }\n" + //
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

    } else {
      resp.sendRedirect("./");
    }

  }

}

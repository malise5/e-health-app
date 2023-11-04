package com.malise.home;

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

@WebServlet(urlPatterns = "/staff")
public class Staff extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession httpSession = req.getSession();

    if (StringUtils.isNotBlank((String) httpSession.getAttribute("LoginId"))) {

      // RequestDispatcher dispatcher = req.getRequestDispatcher("./app/home.html");
      // dispatcher.forward(req, resp);
      ServletContext ctx = getServletContext();

      PrintWriter print = resp.getWriter();

      print.write("<!DOCTYPE html>\n" + //
          "<html>\n" + //
          "    <head>\n" + //
          "        <title>Hospital Information Dashboard</title>\n" + //
          "        <style>\n" + //
          "            body {\n" + //
          "                font-family: Arial, sans-serif;\n" + //
          "                background-color: #f3f3f3;\n" + //
          "                margin: 0;\n" + //
          "                padding: 0;\n" + //
          "            }\n" + //
          "\n" + //
          "        .navbar {\n" + //
          "            display: flex;\n" + //
          "            justify-content: space-between;\n" + //
          "            align-items: center;\n" + //
          "            background-color: #3498db; /* Background color */\n" + //
          "            padding: 10px 20px;\n" + //
          "        }\n" + //
          "\n" + //
          "      \n" + //
          "        .logo img {\n" + //
          "            height: 40px; /* Logo height */\n" + //
          "        }\n" + //
          "\n" + //
          "        /* Style the navigation links */\n" + //
          "        .nav-links {\n" + //
          "            list-style: none;\n" + //
          "            padding: 0;\n" + //
          "            margin: 0;\n" + //
          "        }\n" + //
          "\n" + //
          "        .nav-links li {\n" + //
          "            display: inline;\n" + //
          "            margin-right: 15px; /* Spacing between links */\n" + //
          "        }\n" + //
          "\n" + //
          "        .nav-links a {\n" + //
          "            text-decoration: none;\n" + //
          "            color: #fff; /* Link color */\n" + //
          "            font-weight: bold;\n" + //
          "        }\n" + //
          "\n" + //
          "        .nav-links a:hover {\n" + //
          "            color: #ff9900; \n" + //
          "        }" +
          ".nav-links a.active {\n" + //
          "            color: #ff9900; /* Active link color */\n" + //
          "        }" +
          "\n" + //
          "            header {\n" + //
          "                background-color: #3498db;\n" + //
          "                color: #fff;\n" + //
          "                text-align: center;\n" + //
          "                margin: 20px 0;\n" + //
          "                padding: 5px 0;\n" + //
          "            }\n" + //
          "\n" + //
          "            h1 {\n" + //
          "                font-size: 24px;\n" + //
          "            }\n" + //
          "\n" + //
          "            .container {\n" + //
          "                max-width: 800px;\n" + //
          "                margin: 20px auto;\n" + //
          "                padding: 20px;\n" + //
          "                background-color: #fff;\n" + //
          "                border-radius: 5px;\n" + //
          "                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" + //
          "            }\n" + //
          "\n" + //
          "            table {\n" + //
          "                width: 100%;\n" + //
          "                border-collapse: collapse;\n" + //
          "                margin-top: 20px;\n" + //
          "            }\n" + //
          "\n" + //
          "            th,\n" + //
          "            td {\n" + //
          "                padding: 12px 15px;\n" + //
          "                text-align: left;\n" + //
          "            }\n" + //
          "\n" + //
          "            th {\n" + //
          "                background-color: #3498db;\n" + //
          "                color: #fff;\n" + //
          "            }\n" + //
          "\n" + //
          "            tr:nth-child(even) {\n" + //
          "                background-color: #f2f2f2;\n" + //
          "            }\n" + //
          "\n" + //
          "            tr:nth-child(odd) {\n" + //
          "                background-color: #e6e6e6;\n" + //
          "            }\n" + //
          "        </style>\n" + //
          "    </head>\n" + //
          "    <body>\n" +
          "<nav class=\"navbar\">\n" + //
          "        <div class=\"logo\">\n" + //
          "            <h4>User " + ctx.getAttribute("username") + "</h4>\n" + //
          "        </div>\n" + //
          "        <ul class=\"nav-links\">\n" + //
          "            <li><a href=\"./home\">Home</a></li>\n" + //
          "            <li><a class=\"active\" href=\"./staff\">Staff</a></li>\n" + //
          "            <li><a href=\"#\">Word</a></li>\n" + //
          "            <li><a href=\"#\">Room</a></li>\n" + //
          "            <li><a href=\"#\">Bed</a></li>\n" + //
          "        </ul>\n" + //
          "    </nav>" +
          "<div><a href=\"./logout\" >Logout</a></div>\n" + //
          "        <header>\n" + //
          "            <h1>Staff Information</h1>\n" + //
          "        </header>\n" + //
          "\n" + //
          "        <div class=\"container\">\n");
      print.write("Staff Members info will Appear Here");
      print.write("\n" + //
          "    </div>\n" + //
          "    </body>\n" + //
          "</html>\n" + //
          "");

    } else {
      resp.sendRedirect("./");
    }
  }

}

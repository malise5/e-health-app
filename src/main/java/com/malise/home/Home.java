package com.malise.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.malise.app.bean.DoctorBean;
import com.malise.app.bean.DoctorBeanI;

@WebServlet("/home")
public class Home extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // RequestDispatcher dispatcher = req.getRequestDispatcher("./app/home.html");
    // dispatcher.forward(req, resp);

    DoctorBeanI doctorBean = new DoctorBean();
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
        "            header {\n" + //
        "                background-color: #3498db;\n" + //
        "                color: #fff;\n" + //
        "                text-align: center;\n" + //
        "                padding: 20px 0;\n" + //
        "            }\n" + //
        "\n" + //
        "            h1 {\n" + //
        "                font-size: 36px;\n" + //
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
        "    <body>\n" + //
        "        <header>\n" + //
        "            <h1>Doctor Information Dashboard</h1>\n" + //
        "        </header>\n" + //
        "\n" + //
        "        <div class=\"container\">\n");
    print.write(doctorBean.chartOfDoctors());
    print.write(
        "            \n" + //
            "        </div>\n" + //
            "    </body>\n" + //
            "</html>\n" + //
            "");

  }

}

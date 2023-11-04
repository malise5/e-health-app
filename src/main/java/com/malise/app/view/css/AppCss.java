package com.malise.app.view.css;

import java.io.Serializable;

public class AppCss implements Serializable {

  private String style = "        <style>\n" + //
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
      "            background-color: #3498db;\n" + //
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
      "                margin-top: 10px;\n" + //
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
      "        </style>"; //

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

}

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
      trBuilder.append("<th>" + field.getName() + "</th>");
    }
    trBuilder.append("</tr>");

    for (Object model : models) {

      trBuilder.append("<tr>");

      for (Field field : fields) {
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
    String htmlForm = "<br/>Add Doctor<br/><form action=\"./doctor\" method=\"post\">\n";

    Field[] fields = model.getDeclaredFields();

    for (Field field : fields) {
      String fieldName = field.getName();

      htmlForm += "<label for=\"" + fieldName + "\"><b>" + fieldName + "</b></label><br/>";
      htmlForm += " <input type=\"text\" id=\"" + fieldName + "\" placeholder=\"Enter Index\" name=\"" + fieldName
          + "\" required>\n";

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

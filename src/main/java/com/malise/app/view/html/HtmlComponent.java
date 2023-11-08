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

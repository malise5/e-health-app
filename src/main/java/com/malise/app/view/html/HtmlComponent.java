package com.malise.app.view.html;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.spi.CDI;

import org.apache.commons.lang3.StringUtils;

import com.malise.app.utils.Selector;

public class HtmlComponent implements Serializable {

  public static String table(List<? extends Object> models) {

    if (models == null || models.isEmpty()) {
      return StringUtils.EMPTY;
    }

    // Field[] fields = models.get(0).getClass().getDeclaredFields();
    List<Field> fields = new ArrayList<>(Arrays.asList(models.get(0).getClass().getSuperclass().getDeclaredFields()));
    fields.addAll(Arrays.asList(models.get(0).getClass().getDeclaredFields()));

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
    trBuilder.append("<th>Actions</th>"); // Add a column for Actions button
    trBuilder.append("</tr>");

    for (Object model : models) {

      Object id = null;
      try {
        id = models.get(0).getClass().getMethod("getId").invoke(model);
        System.out.println("The id is " + id);
      } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
          | NoSuchMethodException | SecurityException e) {
        e.printStackTrace();
      }

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

      }

      // Add edit and delete buttons for each row
      // Inside your Java code where you generate the HTML
      trBuilder.append("<td class=\"action-buttons\">");
      // trBuilder.append("<button class=\"edit-button\"
      // onclick=\"openModal()\">Edit</button>");
      if (models.get(0).getClass().isAnnotationPresent(HtmlTable.class)) {
        HtmlTable htmltable = models.get(0).getClass().getAnnotation(HtmlTable.class);
        trBuilder
            .append(
                "<button class=\"delete-button\" onclick=\"window.location.href=('" + htmltable.deleteUrl() + "" + id
                    + "')\">Delete</button>");
        trBuilder.append("</td>");
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

    Field[] fields = model.getDeclaredFields();

    for (Field field : fields) {
      if (!field.isAnnotationPresent(AnnoHtmlFormField.class)) {
        continue;
      }

      AnnoHtmlFormField formField = field.getAnnotation(AnnoHtmlFormField.class);

      String fieldName = field.getName();

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

      // ==========3333
      // if (StringUtils.isNotBlank(formField.selectList())
      // && StringUtils.isNotBlank(formField.selectValue())
      // && StringUtils.isNotBlank(formField.selectDisplay())) {
      // try {
      // StringBuilder stringBuilder = new StringBuilder()
      // .append("<select")
      // .append(" id=\"").append(fieldName)
      // .append("\" name=\"").append(fieldName).append("\" ")
      // .append(formField.required() ? "required" : "")
      // .append(">\n");

      // Selector genericCombo = CDI.current().select(Selector.class).get();

      // Method selectListMethod =
      // Selector.class.getDeclaredMethod(formField.selectList());

      // List<?> options = (List<?>) selectListMethod.invoke(genericCombo);

      // System.out.println(">>>>>>>>>" + options.toString());
      // for (Object option : options) {
      // Field valueField = formField.selectValueInSuper()
      // ? option.getClass().getSuperclass().getDeclaredField(formField.selectValue())
      // : option.getClass().getDeclaredField(formField.selectValue());
      // valueField.setAccessible(true);

      // Field displayField = formField.selectDisplayInSuper()
      // ?
      // option.getClass().getSuperclass().getDeclaredField(formField.selectDisplay())
      // : option.getClass().getDeclaredField(formField.selectDisplay());
      // displayField.setAccessible(true);

      // stringBuilder.append("<option
      // value=\"").append(valueField.get(option)).append("\">")
      // .append(displayField.get(option)).append("</option>\n");
      // }

      // stringBuilder.append("</select> <br>\n");
      // htmlForm += stringBuilder.toString();
      // continue;
      // } catch (NoSuchFieldException | NoSuchMethodException |
      // IllegalAccessException | InvocationTargetException ex) {
      // System.out.println(ex.getMessage());
      // }
      // }
      // ==========3333

    }

    htmlForm += "<button type=\"submit\">Add</button>\n";
    htmlForm += " </form>\n";//

    return htmlForm;

  }

}

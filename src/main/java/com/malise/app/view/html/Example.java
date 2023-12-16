// package com.malise.app.view.html;
// import com.winnie.database.helper.DbTableId;
// import com.winnie.utility.SelectBoxStore;
// import org.apache.commons.lang3.StringUtils;

// import javax.enterprise.inject.spi.CDI;
// import java.io.Serializable;
// import java.lang.reflect.Field;
// import java.lang.reflect.InvocationTargetException;
// import java.lang.reflect.Method;
// import java.math.BigDecimal;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Date;
// import java.util.List;

// public class HtmlComponent implements Serializable {

// public static String table(Class<?>clazz,List<?> models) {

// // Class<?> clazz = models.get(0).getClass();
// if (!clazz.isAnnotationPresent(HtmlTable.class))
// return StringUtils.EMPTY;

// HtmlTable htmlTable = clazz.getAnnotation(HtmlTable.class);

// List<Field> fields = new
// ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
// fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

// StringBuilder trBuilder = new StringBuilder();
// trBuilder.append("<table><tr>");
// trBuilder.append( "<div class=\"addHouseButton\" >\n" +
// " <a href=\""+htmlTable.addUrl()+"\">Add " + htmlTable.name() +"</a>\n" +
// "</div>");
// trBuilder.append("<h4> List of " + htmlTable.name() + "</h4>");

// for (Field field : fields) {
// if (!field.isAnnotationPresent(WinnieTableColHeader.class))
// continue;
// else
// trBuilder.append("<th>" +
// field.getAnnotation(WinnieTableColHeader.class).header() + "</th>");

// }

// trBuilder.append("</tr>");
// /*//impementing delete functionality
// if (models!=null && !models.isEmpty())
// {
// for (Object data:models){
// Object id= null;
// try {
// id = clazz.getMethod("getId").invoke(data);
// } catch (IllegalAccessException | IllegalArgumentException |
// InvocationTargetException
// | NoSuchMethodException | SecurityException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// }
// }*/
// for (Object model : models) {
// trBuilder.append("<tr>");
// /* int id =0;*/
// for (Field field : fields) {
// if (!field.isAnnotationPresent(WinnieTableColHeader.class))
// continue;
// try {

// field.setAccessible(true);
// //getting the fieldnames,it's not printing the id.
// System.out.println(field.getName());
// trBuilder.append("<td>").append(field.get(model)).append("</td>");

// } catch (IllegalAccessException e) {
// throw new RuntimeException(e);
// }
// }
// try {

// Object id = clazz.getMethod("getId").invoke(model);
// trBuilder.append("<td>").append("<div class=\"addHouseButton\" >\n" +
// " <a href=\"" + htmlTable.editUrl() + "\">Edit" + htmlTable.name() + "</a>\n"
// +
// "</div></td>");
// trBuilder.append("<td>").append("<div class=\"addHouseButton\" >\n" +
// " <a href=\"" + htmlTable.deleteUrl()).append(id);
// trBuilder.append("\">Delete" + htmlTable.name() + "</a>\n" +
// "</div></td>");

// trBuilder.append("</tr>");
// } catch (InvocationTargetException | IllegalAccessException |
// NoSuchMethodException e) {
// throw new RuntimeException(e);
// }

// }
// trBuilder.append("</table>");
// return trBuilder.toString();

// }

// public static String htmlForm(Class<?> modelClass) {

// WinnieHtmlForms winnieHtmlForms = null;
// if (modelClass.isAnnotationPresent(WinnieHtmlForms.class))
// winnieHtmlForms = modelClass.getAnnotation(WinnieHtmlForms.class);

// if (winnieHtmlForms == null)
// return StringUtils.EMPTY;

// String htmlForm = "<div class=\"login-container\">" +
// "<br/>Add " + modelClass.getSimpleName() + "<br/>" +
// "<form action=\"./" + modelClass.getSimpleName().toLowerCase() + "\"
// method=\"post\">";
// //"<div class=\"login-container\">";

// Field[] fields = modelClass.getDeclaredFields();

// for (Field field : fields) {
// if (!field.isAnnotationPresent(WinnieHtmlFormField.class))
// continue;
// WinnieHtmlFormField formField =
// field.getAnnotation(WinnieHtmlFormField.class);
// field.setAccessible(true);
// String fieldName = field.getName();
// htmlForm += "<label for=\"" + (StringUtils.isBlank(formField.labelFor()) ?
// fieldName : formField.labelFor())
// + "\">"
// + (StringUtils.isBlank(formField.label()) ? fieldName : formField.label()) +
// ":</label><br>";

// Class<?> fieldType = field.getType();

// //=========================================================================================
// if (StringUtils.isNotBlank(formField.selectList())
// && StringUtils.isNotBlank(formField.selectValue())
// && StringUtils.isNotBlank(formField.selectDisplay())) {
// try {

// StringBuilder stringBuilder =new StringBuilder().
// append("<select")
// .append(" id=\"").append( fieldName)
// .append("\" name=\"").append( fieldName).append("\" ")
// .append(formField.required()?"required" : "")
// .append(">");

// SelectBoxStore genericCombo =
// CDI.current().select(SelectBoxStore.class).get();

// Method selectListMethod =
// SelectBoxStore.class.getDeclaredMethod(formField.selectList());

// List<?> options = (List<?>) selectListMethod.invoke(genericCombo);

// System.out.println("TENANT>>>>>>>>>" + options.toString());
// for (Object option : options) {
// Field valueField = formField.selectValueInSuper()?
// option.getClass().getSuperclass().getDeclaredField(formField.selectValue()) :
// option.getClass().getDeclaredField(formField.selectValue());
// valueField.setAccessible(true);

// Field displayField = formField.selectDisplayInSuper()?
// option.getClass().getSuperclass().getDeclaredField(formField.selectDisplay())
// :
// option.getClass().getDeclaredField(formField.selectDisplay());
// displayField.setAccessible(true);
// stringBuilder.append("htmlForm.append(<option value=\"")
// .append(valueField.get(option)).append("\">")
// .append(displayField.get(option)).append("</option>)");
// }

// stringBuilder.append("</select> <br>");
// htmlForm += stringBuilder.toString();
// continue;
// } catch (NoSuchFieldException | NoSuchMethodException |
// IllegalAccessException | InvocationTargetException ex) {
// System.out.println(ex.getMessage());
// }

// //=========================================================================================

// }
// if (fieldType.isEnum()) {
// htmlForm += "<select name=\"" + (StringUtils.isBlank(formField.selectName())
// ? fieldName : formField.selectName())
// + "\" id=\"" + (StringUtils.isBlank(formField.id()) ? fieldName :
// formField.id()) + "\">";
// Object[] enumConstants = fieldType.getEnumConstants();
// for (Object enumConstant : enumConstants) {
// htmlForm += "<option value=\"" + enumConstant.toString() + "\">" +
// enumConstant.toString() + "</option>";
// }
// htmlForm += "</select><br>";
// } else if (fieldType == String.class) {
// htmlForm += "<input type=\"text\" id=\"" +
// (StringUtils.isBlank(formField.id()) ? fieldName : formField.id())
// + "\" name=\""
// + (StringUtils.isBlank(formField.name()) ? fieldName : formField.name()) +
// "\"><br>";
// } else if (fieldType == int.class || fieldType == Integer.class || fieldType
// == double.class || fieldType == Double.class) {
// htmlForm += "<input type=\"number\" step=\"any\" id=\"" +
// (StringUtils.isBlank(formField.id()) ? fieldName : formField.id())
// + "\" name=\"" + (StringUtils.isBlank(formField.name()) ? fieldName :
// formField.name()) + "\"><br>";
// } else if (fieldType == Date.class) {
// htmlForm += "<input type=\"date\" id=\"" +
// (StringUtils.isBlank(formField.id()) ? fieldName : formField.id())
// + "\" name=\"" + (StringUtils.isBlank(formField.name()) ? fieldName :
// formField.name()) + "\"><br>";
// } else if (fieldType == BigDecimal.class) {
// htmlForm += "<input type=\"number\" step=\"any\" id=\"" +
// (StringUtils.isBlank(formField.id()) ? fieldName : formField.id())
// + "\" name=\"" + (StringUtils.isBlank(formField.name()) ? fieldName :
// formField.name()) + "\"><br><br>";

// }else if(fieldType== Long.class){

// htmlForm += "<input type=\"number\" id=\"" +
// (StringUtils.isBlank(formField.id()) ? fieldName : formField.id())
// + "\" name=\""
// + (StringUtils.isBlank(formField.name()) ? fieldName : formField.name()) +
// "\"><br>";
// }
// // Add additional handling for other data types if needed
// }

// htmlForm += "<input type=\"submit\" value=\"Add " +
// modelClass.getSimpleName() + "\">";
// htmlForm += "</div>" +
// "</form>" +
// "<br/><hr/><br/>";

// return htmlForm;
// }
// }
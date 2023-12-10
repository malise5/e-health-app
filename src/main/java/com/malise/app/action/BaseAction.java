/**
 * The BaseAction class is a Java servlet that provides methods for serializing form data into objects
 * and rendering pages with specified content.
 */
package com.malise.app.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.faces.convert.EnumConverter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;

public class BaseAction extends HttpServlet {

  // @SuppressWarnings("unchecked")
  // public <T> T serializeFormBk(Class<?> clazz, Map<String, String[]>
  // requestMap) {

  // T clazzInstance;

  // try {
  // clazzInstance = (T) clazz.getDeclaredConstructor().newInstance();

  // DateConverter converter = new DateConverter(null);
  // converter.setPattern("yyyy-MM-dd");
  // ConvertUtils.register(converter, Date.class);
  // ConvertUtils.register((Converter) new EnumConverter(), Date.class);

  // BeanUtils.populate(clazzInstance, requestMap);

  // } catch (IllegalAccessException | InvocationTargetException |
  // NoSuchMethodException | InstantiationException e) {
  // throw new RuntimeException(e);
  // }

  // return clazzInstance;
  // }

  public void serializeForm(Object bean, Map<String, ? extends Object> requestMap) {

    try {
      // Registering a custom DateConverter with the desired date format
      DateConverter dateConverter = new DateConverter(null);
      dateConverter.setPattern("yyyy-MM-dd");

      ConvertUtils.register(dateConverter, Date.class);

      // Populating the bean using BeanUtils
      BeanUtils.populate(bean, requestMap);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  public void renderPage(HttpServletRequest request, HttpServletResponse response, int activeMenu, String content)
      throws ServletException, IOException {

    request.setAttribute("activeMenu", activeMenu);

    request.setAttribute("content", content);

    RequestDispatcher dispatcher = request.getRequestDispatcher("./app/index.jsp");
    dispatcher.forward(request, response);
  }

}

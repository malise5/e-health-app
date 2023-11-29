/**
 * The BaseAction class is a Java servlet that provides methods for serializing form data into objects
 * and rendering pages with specified content.
 */
package com.malise.app.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

public class BaseAction extends HttpServlet {

  public void serializeForm(Object bean, Map<String, ? extends Object> requestMap) {

    try {
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

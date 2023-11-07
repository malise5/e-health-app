package com.malise.app.action;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServlet;

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

}

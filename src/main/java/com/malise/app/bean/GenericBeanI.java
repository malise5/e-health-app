package com.malise.app.bean;

import java.util.List;

public interface GenericBeanI<T> {

  List<T> getList(Class<?> entity);

  // String getTableHTML();

  void add(T entity);

  void delete(T entity);

}

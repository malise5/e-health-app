package com.malise.app.bean;

import java.util.List;

public interface GenericBeanI<T> {

  List<T> getList();

  String getTableHTML();

  T add(T entity);

  void delete(T entity);

}

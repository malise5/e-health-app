package com.malise.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable {

  List<T> getList(T entity);

  void add(T entity);

  void delete(T entity);

}

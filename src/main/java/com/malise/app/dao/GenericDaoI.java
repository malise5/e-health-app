package com.malise.app.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoI<T> extends Serializable {

  List<T> getList(Class<?> entity);

  void add(T entity);

  void delete(T entity);

}

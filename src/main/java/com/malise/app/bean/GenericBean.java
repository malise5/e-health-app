package com.malise.app.bean;

import java.util.List;

public class GenericBean<T> implements GenericBeanI<T> {

  @Override
  public List<T> getList() {
    return null;

  }

  @Override
  public String getTableHTML() {
    return null;
  }

  @Override
  public T add(T entity) {
    return null;
  }

  @Override
  public void delete(T entity) {

  }

}

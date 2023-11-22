package com.malise.app.dao;

import java.util.List;

import com.malise.database.MysqlDb;

public class GenericDao<T> implements GenericDaoI<T> {

  @SuppressWarnings({ "unchecked" })
  @Override
  public List<T> getList(Class<?> entity) {
    return (List<T>) MysqlDb.select(entity);
  }

  @Override // add or update
  public void add(T entity) {
    MysqlDb.insert(entity);
  }

  @Override
  public void delete(T entity) {

  }

}

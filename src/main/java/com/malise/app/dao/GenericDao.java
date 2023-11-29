package com.malise.app.dao;

import java.util.List;

import javax.ejb.EJB;

import com.malise.database.MysqlDb;

public class GenericDao<T> implements GenericDaoI<T> {

  @EJB
  MysqlDb database;

  @SuppressWarnings({ "unchecked" })
  @Override
  public List<T> getList(Class<?> entity) {
    return (List<T>) database.select(entity);
  }

  @Override // add or update
  public void add(T entity) {
    database.insert(entity);
  }

  @Override
  public void delete(T entity) {

  }

  @Override
  public MysqlDb getDatabase() {
    return database;
  }

  @Override
  public void setDatabase(MysqlDb database) {
    this.database = database;
  }

}

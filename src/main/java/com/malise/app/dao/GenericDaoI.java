package com.malise.app.dao;

import java.io.Serializable;
import java.util.List;

import com.malise.database.MysqlDb;

public interface GenericDaoI<T> extends Serializable {

  List<T> getList(Class<?> entity);

  void add(T entity);

  void delete(T entity);

  MysqlDb getDatabase();

  void setDatabase(MysqlDb database);

}

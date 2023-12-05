package com.malise.app.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

// import com.malise.database.MysqlDb;

public interface GenericDaoI<T> extends Serializable {

  List<T> getList(T entity);

  void add(T entity);

  void delete(T entity);

  // MysqlDb getDatabase();
  EntityManager getEm();

  // void setDatabase(MysqlDb database);
  void setEm(EntityManager em);

}

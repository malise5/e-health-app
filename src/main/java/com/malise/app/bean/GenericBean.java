package com.malise.app.bean;

import java.util.List;

import javax.ejb.EJB;

import com.malise.app.dao.GenericDao;
import com.malise.app.dao.GenericDaoI;
// import com.malise.database.Database;
import com.malise.database.MysqlDb;

public abstract class GenericBean<T> implements GenericBeanI<T> {

  @EJB
  MysqlDb database;

  private final GenericDaoI<T> genericDao = new GenericDao<>();

  @Override
  public List<T> getList(Class<?> entity) {
    // return (List<T>) Database.getDbInstance().getData(entity);
    genericDao.setDatabase(database);
    return genericDao.getList(entity);

  }

  @Override
  public void add(T entity) {
    genericDao.setDatabase(database);
    genericDao.add(entity);
  }

  @Override
  public void delete(T entity) {

  }

  public GenericDao<T> getDao() {
    genericDao.setDatabase(database);
    return (GenericDao<T>) genericDao;

  }

}

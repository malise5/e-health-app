package com.malise.app.bean;

import java.util.List;

import com.malise.app.dao.GenericDao;
import com.malise.app.dao.GenericDaoI;
// import com.malise.database.Database;
import com.malise.database.MysqlDb;

public abstract class GenericBean<T> implements GenericBeanI<T> {

  private final GenericDaoI<T> genericDao = new GenericDao<>();

  // @SuppressWarnings({ "unchecked" })
  @Override
  public List<T> getList(Class<?> entity) {
    // return (List<T>) Database.getDbInstance().getData(entity);
    return genericDao.getList(entity);

  }

  @Override
  public void add(T entity) {
    MysqlDb.insert(entity);
  }

  @Override
  public void delete(T entity) {

  }

  public GenericDao<T> getDao() {
    return (GenericDao<T>) genericDao;

  }

}

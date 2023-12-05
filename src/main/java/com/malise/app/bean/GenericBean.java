package com.malise.app.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.malise.app.dao.GenericDao;
import com.malise.app.dao.GenericDaoI;
// import com.malise.database.Database;
// import com.malise.database.MysqlDb;

public abstract class GenericBean<T> implements GenericBeanI<T> {

  // @EJB
  // MysqlDb database;
  @PersistenceContext
  private EntityManager em;

  @Inject
  private GenericDaoI<T> genericDao;

  @Override
  public List<T> getList(T entity) {
    // genericDao.setDatabase(database);
    genericDao.setEm(em);
    return genericDao.getList(entity);

  }

  @Override
  public void add(T entity) {
    // genericDao.setDatabase(database);
    genericDao.setEm(em);
    genericDao.add(entity);
  }

  // changed
  @Override
  public void delete(T entity) {
    // genericDao.setDatabase(database);
    genericDao.setEm(em);
    genericDao.delete(entity);

  }

  public GenericDao<T> getDao() {
    // genericDao.setDatabase(database);
    genericDao.setEm(em);
    return (GenericDao<T>) genericDao;

  }

}

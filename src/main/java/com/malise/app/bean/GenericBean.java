package com.malise.app.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.malise.app.dao.GenericDao;
import com.malise.app.dao.GenericDaoI;

public abstract class GenericBean<T> implements GenericBeanI<T> {

  @PersistenceContext
  private EntityManager em;

  @Inject
  private GenericDaoI<T> genericDao;

  @Override
  public List<T> getList(T entity) {
    genericDao.setEm(em);
    return genericDao.getList(entity);

  }

  @Override
  public void add(T entity) {
    genericDao.setEm(em);
    genericDao.add(entity);
  }

  // changed
  @Override
  public void delete(T entity) {
    genericDao.setEm(em);
    genericDao.delete(entity);

  }

  public GenericDao<T> getDao() {
    genericDao.setEm(em);
    return (GenericDao<T>) genericDao;

  }

}

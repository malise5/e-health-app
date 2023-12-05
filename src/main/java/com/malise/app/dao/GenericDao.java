package com.malise.app.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// import com.malise.database.MysqlDb;
import java.lang.reflect.Field;

public class GenericDao<T> implements GenericDaoI<T> {

  // @EJB
  // private MysqlDb database;
  @PersistenceContext
  private EntityManager em;

  @SuppressWarnings({ "unchecked" })
  @Override
  public List<T> getList(T entity) {
    String jpql = "FROM " + entity.getClass().getSimpleName() + " e";

    List<T> results = (List<T>) em.createQuery(jpql, entity.getClass()).getResultList();

    return results;

  }

  @Override
  public void add(T entity) {
    em.merge(entity);
  }

  @Override
  public void delete(T entity) {
    em.detach(entity);
  }

  @Override
  public EntityManager getEm() {
    return em;
  }

  @Override
  public void setEm(EntityManager em) {
    this.em = em;
  }

  // @Override // add or update
  // public void add(T entity) {
  // database.insert(entity);
  // }

  // // changed
  // @Override
  // public void delete(T entity) {
  // }

  // @Override
  // public MysqlDb getDatabase() {
  // return database;
  // }

  // @Override
  // public void setDatabase(MysqlDb database) {
  // this.database = database;
  // }

}

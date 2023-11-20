package com.malise.app.bean;

import java.util.List;
import com.malise.database.Database;
import com.malise.database.MysqlDb;

public class GenericBean<T> implements GenericBeanI<T> {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  @Override
  public List<T> getList(Class<?> entity) {
    return (List<T>) Database.getDbInstance().getData(entity);

  }

  // @Override
  // public String getTableHTML() {
  // return null;
  // }

  @Override
  public void add(T entity) {

    MysqlDb.insert(entity);
    // Database database = Database.getDbInstance();

    // if (entity instanceof Doctor) {
    // database.getDoctor().add((Doctor) entity);
    // }

    // else if (entity instanceof Ward) {
    // database.getWard().add((Ward) entity);
    // }

    // else if (entity instanceof Apparatus) {
    // database.getApparatus().add((Apparatus) entity);
    // }

    // else if (entity instanceof User) {
    // database.getUsers().add((User) entity);
    // }

    // return entity;

    // Database database = Database.getDbInstance();
    // database.getData().add(entity);
  }

  @Override
  public void delete(T entity) {

  }

}

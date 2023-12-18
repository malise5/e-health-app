package com.malise.app.dao;

import java.util.List;
// import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDao<T> implements GenericDaoI<T> {

  // @EJB
  // private MysqlDb database;
  @PersistenceContext
  private EntityManager em;

  @SuppressWarnings({ "unchecked" })
  @Override
  public List<T> getList(T entity) {
    String jpql = "FROM " + entity.getClass().getSimpleName() + " e";

    List<T> results = (List<T>) em.createQuery(jpql,
        entity.getClass()).getResultList();

    return results;

  }

  @Override
  public void add(T entity) {
    em.merge(entity);
  }

  @Override
  public void delete(T entity) {
    em.remove(em.contains(entity) ? entity : em.merge(entity));
  }

  @Override
  public EntityManager getEm() {
    return em;
  }

  @Override
  public void setEm(EntityManager em) {
    this.em = em;
  }

}

// Class<?> clazz = entity.getClass();

// String simpleName = entity.getClass().getSimpleName();

// String tAlias = (simpleName.charAt(0) + "_").toLowerCase();
// String jpql = "FROM " + entity.getClass().getSimpleName() + " " + tAlias;

// StringBuilder whereClause = new StringBuilder();
// Map<String, Object> whereParams = new HashMap<>();

// List<Field> fields = new
// ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
// fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

// for (Field field : fields) {
// if (!field.isAnnotationPresent(Column.class) &&
// !field.isAnnotationPresent(Formula.class)
// && !field.isAnnotationPresent(Id.class))
// continue;

// field.setAccessible(true);

// try {
// if (field.get(entity) != null) {
// String colName = field.getName();

// whereClause
// .append(whereParams.isEmpty() ? "" : " AND ")
// .append(tAlias).append(".").append(colName).append("=:").append(colName);

// whereParams.put(colName, field.get(entity));
// }

// } catch (IllegalAccessException iEx) {
// iEx.printStackTrace();

// }
// }

// jpql = jpql + (whereParams.isEmpty() && StringUtils.isBlank(whereClause) ? ""
// : " WHERE " + whereClause);

// jpql = jpql.replace(", FROM", " FROM");
// System.out.println("jpql: " + jpql);

// TypedQuery<T> query = (TypedQuery<T>) em.createQuery(jpql,
// entity.getClass());

// for (Map.Entry<String, Object> entry : whereParams.entrySet()) {
// System.out.println("param Name: " + entry.getKey() + " = " +
// entry.getValue());
// query = query.setParameter(entry.getKey(), entry.getValue());
// }

// return query.getResultList();
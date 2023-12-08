package com.malise.app.bean;

import java.io.Serializable;
import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.malise.app.model.entity.AuditLog;

@Singleton
public class AuditLogBean implements Serializable {

  @PersistenceContext
  private EntityManager em;

  public void log(@Observes AuditLog auditLOg) {
    System.out.println("Adding audit log!!");
    em.merge(auditLOg);
  }

}

package com.malise.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "audit_logs")
public class AuditLog extends BaseEntity {

  private String logDetails;

  @Column(name = "log_details", columnDefinition = "longtext")

  public String getLogDetails() {
    return logDetails;
  }

  public void setLogDetails(String logDetails) {
    this.logDetails = logDetails;
  }

}

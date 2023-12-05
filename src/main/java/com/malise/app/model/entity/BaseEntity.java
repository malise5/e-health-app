package com.malise.app.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

// import com.malise.app.view.html.AnnoTableHeader;
// import com.malise.database.helper.DbTableColumn;
// import com.malise.database.helper.DbTableId;

@MappedSuperclass
public class BaseEntity implements Serializable {

  // @DbTableId
  @Id
  // @DbTableColumn(name = "id", defination = "int")
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}

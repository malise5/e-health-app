package com.malise.app.model.entity;

import java.io.Serializable;

// import com.malise.app.view.html.AnnoTableHeader;
import com.malise.database.helper.DbTableColumn;
import com.malise.database.helper.DbTableId;

public class BaseEntity implements Serializable {

  @DbTableId
  // @AnnoTableHeader(header = "index")
  @DbTableColumn(name = "id", defination = "int")
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}

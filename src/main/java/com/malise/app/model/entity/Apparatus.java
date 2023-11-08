package com.malise.app.model.entity;

import com.malise.app.view.html.AnnoHtmlForm;
import com.malise.app.view.html.AnnoHtmlFormField;
import com.malise.app.view.html.AnnoTableHeader;

@AnnoHtmlForm(label = "Apparatus", url = "./apparatus")
public class Apparatus {

  @AnnoTableHeader(header = "Id")
  @AnnoHtmlFormField(label = "id")
  private int apparatusId;

  @AnnoTableHeader(header = "Apparatus Name")
  @AnnoHtmlFormField(label = "apparatus-Name")
  private String apparatusName;

  @AnnoTableHeader(header = "Quantity")
  @AnnoHtmlFormField(label = "quantity")
  private int quantity;

  public int getApparatusId() {
    return apparatusId;
  }

  public void setApparatusId(int apparatusId) {
    this.apparatusId = apparatusId;
  }

  public String getApparatusName() {
    return apparatusName;
  }

  public void setApparatusName(String apparatusName) {
    this.apparatusName = apparatusName;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

}

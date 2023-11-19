package com.malise.app.model.entity;

import com.malise.app.view.html.AnnoHtmlForm;
import com.malise.app.view.html.AnnoHtmlFormField;
import com.malise.app.view.html.AnnoTableHeader;
import com.malise.database.helper.DbTable;
import com.malise.database.helper.DbTableColumn;

@DbTable(nameOfTable = "apparatus")
@AnnoHtmlForm(label = "Apparatus", url = "./apparatus")
public class Apparatus {

  @DbTableColumn(name = "id", defination = "int")
  @AnnoTableHeader(header = "Id")
  @AnnoHtmlFormField(label = "id")
  private int apparatusId;

  @DbTableColumn(name = "apparatus_name")
  @AnnoTableHeader(header = "Apparatus Name")
  @AnnoHtmlFormField(label = "apparatus-Name")
  private String apparatusName;

  @DbTableColumn(name = "quantity")
  @AnnoTableHeader(header = "Quantity")
  @AnnoHtmlFormField(label = "quantity")
  private int quantity;

  public Apparatus() {
  }

  public Apparatus(int apparatusId, String apparatusName, int quantity) {
    this.apparatusId = apparatusId;
    this.apparatusName = apparatusName;
    this.quantity = quantity;
  }

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

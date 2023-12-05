package com.malise.app.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.malise.app.view.html.AnnoHtmlForm;
import com.malise.app.view.html.AnnoHtmlFormField;
import com.malise.app.view.html.AnnoTableHeader;
import com.malise.database.helper.DbTable;
import com.malise.database.helper.DbTableColumn;

// @WebServlet("ward")
@Entity
// @DbTable(nameOfTable = "wards")
@Table(name = "wards")
@AnnoHtmlForm(label = "Ward", url = "./ward")
public class Ward extends BaseEntity {

  // @DbTableColumn(name = "ward_name")
  @Column(name = "ward_name", nullable = false)
  @AnnoTableHeader(header = "Ward-Name")
  @AnnoHtmlFormField(label = "Name")
  private String wardName;

  // @DbTableColumn(name = "ward_currentOccupancy")
  @Column(name = "ward_currentOccupancy")
  @AnnoTableHeader(header = "currentOccupancy")
  @AnnoHtmlFormField
  private int currentOccupancy;

  // @DbTableColumn(name = "ward_capacity")
  @Column(name = "ward_capacity")
  @AnnoTableHeader(header = "Maximum_Capacity")
  // @AnnoHtmlFormField
  private int capacity;

  public Ward() {
  }

  public Ward(String wardName, int capacity, int currentOccupancy) {
    this.wardName = wardName;
    this.capacity = capacity;
    this.currentOccupancy = currentOccupancy;
  }

  public String getWardName() {
    return wardName;
  }

  public void setWardName(String wardName) {
    this.wardName = wardName;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getCurrentOccupancy() {
    return currentOccupancy;
  }

  public void setCurrentOccupancy(int currentOccupancy) {
    this.currentOccupancy = currentOccupancy;
  }

}

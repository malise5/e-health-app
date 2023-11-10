package com.malise.app.model.entity;

import java.io.Serializable;

import com.malise.app.view.html.AnnoHtmlForm;
import com.malise.app.view.html.AnnoHtmlFormField;
import com.malise.app.view.html.AnnoTableHeader;

// @WebServlet("ward")
@AnnoHtmlForm(label = "Ward", url = "./ward")
public class Ward implements Serializable {

  @AnnoTableHeader(header = "Ward-Name")
  @AnnoHtmlFormField(label = "Name")
  private String wardName;

  @AnnoTableHeader(header = "Capacity")
  @AnnoHtmlFormField
  private int capacity;

  @AnnoTableHeader(header = "currentOccupancy")
  @AnnoHtmlFormField
  private int currentOccupancy;

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

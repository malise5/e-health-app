package com.malise.app.model.entity;

import java.io.Serializable;

import com.malise.app.view.html.AnnoHtmlForm;
import com.malise.app.view.html.AnnoHtmlFormField;
import com.malise.app.view.html.AnnoTableHeader;
import com.malise.database.helper.DbTable;
import com.malise.database.helper.DbTableColumn;

@DbTable(nameOfTable = "doctors")
@AnnoHtmlForm(label = "Doctor", url = "./doctor")
public class Doctor extends BaseEntity {

  // @DbTableColumn(name = "doctor_index")
  // @AnnoTableHeader(header = "index")
  // @AnnoHtmlFormField(label = "index")
  // private String index;

  @DbTableColumn(name = "doctor_name")
  @AnnoTableHeader(header = "Name of Doctor")
  @AnnoHtmlFormField(label = "Name")
  private String name;

  @DbTableColumn(name = "doctor_email")
  @AnnoTableHeader(header = "Email")
  @AnnoHtmlFormField(label = "Email-Address")
  private String email;

  @DbTableColumn(name = "specialization")
  @AnnoTableHeader(header = "Specialization")
  @AnnoHtmlFormField(label = "specialization")
  private String specialization;
  // private String profile;

  public Doctor() {
  }

  public Doctor(String index, String name, String email, String specialization) {
    // this.index = index;
    this.name = name;
    this.email = email;
    this.specialization = specialization;

  }

  // public String getIndex() {
  // return index;
  // }

  // public void setIndex(String index) {
  // this.index = index;
  // }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSpecialization() {
    return specialization;
  }

  public void setSpecialization(String specialization) {
    this.specialization = specialization;
  }

  // @Override
  // public String toString() {
  // StringBuilder trBuilder = new StringBuilder();
  // trBuilder.append("<tr>");
  // trBuilder.append("<td>").append(StringUtils.trimToEmpty(getIndex())).append("</td>");
  // trBuilder.append("<td>").append(StringUtils.trimToEmpty(getName())).append("</td>");
  // trBuilder.append("<td>").append(StringUtils.trimToEmpty(getEmail())).append("</td>");
  // trBuilder.append("<td>").append(StringUtils.trimToEmpty(getSpecialization())).append("</td>");
  // trBuilder.append("<tr>");

  // return trBuilder.toString();
  // }

  // public String getProfile() {
  // return profile;
  // }

  // public void setProfile(String profile) {
  // this.profile = profile;
  // }

}

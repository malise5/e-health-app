package com.malise.app.model.entity;

import javax.persistence.Column;
// import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.malise.app.view.html.AnnoHtmlForm;
import com.malise.app.view.html.AnnoHtmlFormField;
import com.malise.app.view.html.AnnoTableHeader;
import com.malise.app.view.html.HtmlTable;

@Entity
@Table(name = "patients")
@AnnoHtmlForm(label = "Patient", url = "./patient")
@HtmlTable(addUrl = "./patient", deleteUrl = "./patient?type=patient&mode=remove&patientID=")
public class Patient extends BaseEntity {

  @Column(name = "patient_name")
  @AnnoTableHeader(header = "Patient Name")
  @AnnoHtmlFormField(label = "Name")
  private String name;

  @Column(name = "patient_gender")
  @AnnoTableHeader(header = "Patient Gender")
  @AnnoHtmlFormField(label = "Gender")
  private String gender;

  @Column(name = "patient_disease")
  @AnnoTableHeader(header = "Patient Disease")
  @AnnoHtmlFormField(label = "Disease")
  private String disease;

  // @Embedded
  // private Contact contact;

  public Patient() {
  }

  public Patient(String name, String gender, String disease) {
    this.name = name;
    this.gender = gender;
    this.disease = disease;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getDisease() {
    return disease;
  }

  public void setDisease(String disease) {
    this.disease = disease;
  }

  // public Contact getContact() {
  // return contact;
  // }

  // public void setContact(Contact contact) {
  // this.contact = contact;
  // }

}

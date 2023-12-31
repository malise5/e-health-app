package com.malise.app.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.malise.app.view.html.AnnoHtmlForm;
import com.malise.app.view.html.AnnoHtmlFormField;
import com.malise.app.view.html.AnnoTableHeader;
import com.malise.app.view.html.HtmlTable;

@Entity
@Table(name = "doctors")
@AnnoHtmlForm(label = "Doctor", url = "./doctor")
@HtmlTable(addUrl = "./doctor", deleteUrl = "./doctor?type=doctor&mode=remove&doctorID=")
public class Doctor extends BaseEntity {

  @Column(name = "service_id", nullable = false, unique = true)
  @AnnoTableHeader(header = "service_number")
  private String index;

  @Column(name = "doctor_name")
  @AnnoTableHeader(header = "Name of Doctor")
  @AnnoHtmlFormField(label = "Name")
  private String name;

  @Column(name = "doctor_email")
  @AnnoTableHeader(header = "Email")
  @AnnoHtmlFormField(label = "Email-Address")
  private String email;

  @Column(name = "specialization")
  @AnnoTableHeader(header = "Specialization")
  @AnnoHtmlFormField(label = "specialization")
  private String specialization;
  // private String profile;

  @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
  private List<Patient> patients = new ArrayList<>();

  public Doctor() {
  }

  public Doctor(String index, String name, String email, String specialization) {
    this.index = index;
    this.name = name;
    this.email = email;
    this.specialization = specialization;

  }

  public String getIndex() {
    return index;
  }

  public void setIndex(String index) {
    this.index = index;
  }

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

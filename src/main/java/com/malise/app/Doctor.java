package com.malise.app;

import java.io.Serializable;

public class Doctor implements Serializable {

  private String index;
  private String name;
  private String email;
  private String specialization;

  public String getIndex() {
    return index;
  }

  public Doctor() {
  }

  public Doctor(String index, String name, String email, String specialization) {
    this.index = index;
    this.name = name;
    this.email = email;
    this.specialization = specialization;
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

  @Override
  public String toString() {
    StringBuilder trBuilder = new StringBuilder();
    trBuilder.append("<tr>");
    trBuilder.append("<td>").append(getIndex().isBlank() ? "" : getIndex().trim()).append("</td>");
    trBuilder.append("<td>").append(getName().isBlank() ? "" : getName().trim()).append("</td>");
    trBuilder.append("<td>").append(getEmail().isBlank() ? "" : getEmail().trim()).append("</td>");
    trBuilder.append("<td>").append(getSpecialization().isBlank() ? "" : getSpecialization().trim()).append("</td>");
    trBuilder.append("<tr>");

    return trBuilder.toString();
  }

}

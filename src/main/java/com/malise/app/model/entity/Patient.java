package com.malise.app.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
// import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

import com.malise.app.view.html.AnnoHtmlForm;
import com.malise.app.view.html.AnnoHtmlFormField;
import com.malise.app.view.html.AnnoTableHeader;
// import com.malise.app.view.html.DateTypeAnnotations;
// import com.malise.app.view.html.HtmlTable;

@Entity
@Table(name = "patients")
@AnnoHtmlForm(label = "Patient", url = "./patient")
// @HtmlTable(addUrl = "./patient", deleteUrl =
// "./patient?type=patient&mode=remove&patientID=")
public class Patient extends BaseEntity {

  @Column(name = "patient_name")
  @AnnoTableHeader(header = "Patient Name")
  @AnnoHtmlFormField(label = "Name")
  private String name;

  @Column(name = "phone_number")
  @AnnoTableHeader(header = "Phone Number")
  @AnnoHtmlFormField(label = "Phon Number")
  private String phoneNumber;

  @Column(name = "patient_disease")
  @AnnoTableHeader(header = "Patient Disease")
  @AnnoHtmlFormField(label = "Disease")
  private String disease;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

  // @Column(name = "doctor's_id")
  // @AnnoTableHeader(header = "Doctor's Id")
  @AnnoHtmlFormField(label = "Doctor", selectList = "doctors", selectValue = "idTag", selectValueInSuper = true, selectDisplay = "name")
  @Formula("(doctor_id)")
  private Long doctorId;

  @AnnoTableHeader(header = "Doctor's Appointment")
  @Formula("(select c.doctor_name from doctors c where c.id=doctor_id)")
  private String doctorName;

  public Patient() {
  }

  public Patient(String name, String disease) {
    this.name = name;
    // this.gender = gender;
    this.disease = disease;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDisease() {
    return disease;
  }

  public void setDisease(String disease) {
    this.disease = disease;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public Long getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
  }

  public String getDoctorName() {
    return doctorName;
  }

  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

}

package com.malise.app.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
// import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

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

  @Column(name = "phone_number")
  @AnnoTableHeader(header = "Phone Number")
  @AnnoHtmlFormField(label = "Phone Number")
  private String phoneNumber;

  @Column(name = "patient_gender")
  @AnnoTableHeader(header = "Patient Gender")
  @AnnoHtmlFormField(label = "Gender")
  private String gender;

  @Column(name = "patient_disease")
  @AnnoTableHeader(header = "Patient Disease")
  @AnnoHtmlFormField(label = "Disease")
  private String disease;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

  @AnnoTableHeader(header = "Doctor's Appontment")
  @AnnoHtmlFormField(label = "Doctor's Appontment")
  @Formula("(doctor_id)")
  private Long doctorId;

  @AnnoTableHeader(header = "Doctor")
  @Formula("(select c.doctor_name  from doctors c where c.id=doctor_id)")
  private String doctorName;

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

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getDoctorName() {
    return doctorName;
  }

  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
  }

  // public String getDoctorName() {
  // return doctorName;
  // }

  // public void setDoctorName(String doctorName) {
  // this.doctorName = doctorName;
  // }

  // public Contact getContact() {
  // return contact;
  // }

  // public void setContact(Contact contact) {
  // this.contact = contact;
  // }

}

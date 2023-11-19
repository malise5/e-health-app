package com.malise.app.bean;

import java.io.Serializable;
import java.util.List;

import com.malise.app.model.entity.Doctor;
import com.malise.app.view.html.HtmlComponent;

public class DoctorBean extends GenericBean<Doctor> implements DoctorBeanI, Serializable {

  // @Override
  // public List<Doctor> getListOfDoctors() {
  // return Database.getDbInstance().getDoctor();
  // }

  public String getDoctorTableHTML() {
    List<Doctor> doctors = getList(Doctor.class);
    return HtmlComponent.table(doctors);
  }

  // public Doctor addDoctors(Doctor doctor) {
  // Database database = Database.getDbInstance();

  // database.getDoctor().add(doctor);

  // return doctor;
  // }

  // public void deleteDoctor(Doctor account) {

  // }

}

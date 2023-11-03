package com.malise.app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.malise.app.model.Doctor;

public class DoctorBean implements Serializable {

  public String chartOfDoctors() {
    List<Doctor> doctors = new ArrayList<>();

    doctors.add(new Doctor("1", "Halkano Malise", "malise@gmail.com", "Cardiologist"));
    doctors.add(new Doctor("2", "Mohammed Ali", "moha@gmail.com", "Gynaecologist"));

    StringBuilder trBuilder = new StringBuilder();
    trBuilder.append("<table><tr><th>Index</th><th>Name</th><th>Email</th><th>Specialization</th></tr>");

    for (Doctor doctor : doctors) {
      trBuilder.append(doctor.toString());
    }
    trBuilder.append("</table>");
    return trBuilder.toString();

  }

  public Doctor addDoctors(Doctor doctor) throws Exception {
    return null;
  }

  public void deleteDoctor(Doctor account) {

  }

}

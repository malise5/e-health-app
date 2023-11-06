package com.malise.app.bean;

import java.io.Serializable;
import java.util.List;

import com.malise.app.model.entity.Doctor;
import com.malise.database.Database;

public class DoctorBean implements DoctorBeanI, Serializable {

  public String chartOfDoctors() {
    List<Doctor> doctors = Database.getDbInstance().getDoctor();

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

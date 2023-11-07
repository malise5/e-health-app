package com.malise.app.bean;

import java.io.Serializable;
import java.util.List;
// import java.util.UUID;

import com.malise.app.model.entity.Doctor;
import com.malise.app.view.html.HtmlComponent;
import com.malise.database.Database;

public class DoctorBean implements DoctorBeanI, Serializable {

  public String chartOfDoctors() {
    // List<Doctor> doctors = Database.getDbInstance().getDoctor();

    // StringBuilder trBuilder = new StringBuilder();
    // trBuilder.append(HtmlComponent.table(doctors));

    // trBuilder.append("<table><tr><th>Index</th><th>Name</th><th>Email</th><th>Specialization</th></tr>");

    // for (Doctor doctor : doctors) {
    // trBuilder.append(doctor.toString());
    // }
    // trBuilder.append("</table>");
    return HtmlComponent.table(Database.getDbInstance().getDoctor());

  }

  // public Doctor addDoctors(Doctor doctor) throws Exception {
  // return null;
  // }
  public Doctor addDoctors(Doctor doctor) {
    Database database = Database.getDbInstance();

    // String uniqueIdentifier = generateUniqueIdentifier();

    // doctor.setIndex(uniqueIdentifier);

    database.getDoctor().add(doctor);

    return doctor;
  }

  public void deleteDoctor(Doctor account) {

  }

  // // Generate a unique identifier using a combination of a counter and a UUID
  // private String generateUniqueIdentifier() {
  // return UUID.randomUUID().toString();
  // }

}

package com.malise.app.bean;

import java.io.Serializable;

import com.malise.app.model.entity.Doctor;
import com.malise.app.view.html.HtmlComponent;
import com.malise.database.Database;

public class DoctorBean implements DoctorBeanI, Serializable {

  public String chartOfDoctors() {

    return HtmlComponent.table(Database.getDbInstance().getDoctor());

  }

  public Doctor addDoctors(Doctor doctor) {
    Database database = Database.getDbInstance();

    database.getDoctor().add(doctor);

    return doctor;
  }

  public void deleteDoctor(Doctor account) {

  }

}

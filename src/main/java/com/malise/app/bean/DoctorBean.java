package com.malise.app.bean;

// import java.io.Serializable;
// import java.util.List;

import com.malise.app.model.entity.Doctor;
// import com.malise.app.view.html.HtmlComponent;
// import com.malise.database.MysqlDb;

public class DoctorBean extends GenericBean<Doctor> implements DoctorBeanI {

  // public String getDoctorTableHTML() {
  // List<Doctor> doctors = getList(Doctor.class);
  // return HtmlComponent.table(doctors);
  // }

  // overiding
  @Override // add or update
  public void add(Doctor doctor) {
    if (doctor.getName() == null) {
      throw new RuntimeException("Name needed");
    }

    getDao().add(doctor);
  }

}

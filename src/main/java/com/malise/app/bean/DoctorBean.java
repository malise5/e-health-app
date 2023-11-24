package com.malise.app.bean;

import com.malise.app.model.entity.Doctor;

public class DoctorBean extends GenericBean<Doctor> implements DoctorBeanI {

  // overiding
  @Override // add or update
  public void add(Doctor doctor) {
    if (doctor.getName() == null) {
      throw new RuntimeException("Name needed");
    }

    getDao().add(doctor);
  }

}

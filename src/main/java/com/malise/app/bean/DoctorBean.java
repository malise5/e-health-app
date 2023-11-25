package com.malise.app.bean;

import javax.ejb.Stateless;

import com.malise.app.model.entity.Doctor;

@Stateless
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

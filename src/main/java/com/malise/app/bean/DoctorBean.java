package com.malise.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.malise.app.model.entity.Doctor;
import com.malise.app.utils.DoctorNoGenerator;

@Stateless
@Remote
public class DoctorBean extends GenericBean<Doctor> implements DoctorBeanI {

  @Inject
  private DoctorNoGenerator doctorNo;

  // overiding
  @Override // add or update
  public void add(Doctor doctor) {
    doctor.setIndex(doctorNo.generate("P"));
    getDao().add(doctor);
  }

}

package com.malise.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import com.malise.app.model.entity.Doctor;
// import com.malise.app.utils.DoctorNo;
import com.malise.app.utils.DoctorNoGenerator;
import com.malise.app.utils.DoctorNoI;

@Stateless
@Remote
public class DoctorBean extends GenericBean<Doctor> implements DoctorBeanI {

  @Inject
  // @DoctorNo
  @Named("DoctorNumber")
  private DoctorNoI doctorNo;

  // overiding
  @Override // add or update
  public void add(Doctor doctor) {
    doctor.setIndex(doctorNo.generate());
    getDao().add(doctor);
  }

}

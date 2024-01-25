package com.malise.app.bean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import com.malise.app.model.entity.Doctor;
import com.malise.app.utils.DoctorNoI;

@Stateless
@Remote
public class DoctorBean extends GenericBean<Doctor> implements DoctorBeanI {

  @Inject
  @Named("DoctorNumber")
  private DoctorNoI doctorNo;

  @Override // add or update
  public void add(Doctor doctor) {
    doctor.setIndex(doctorNo.generate());
    getDao().add(doctor);
  }

  @Override
  public Doctor getDoctorById(int id) {
    List<Doctor> allDoctor = getDao().getList(new Doctor());
    for (Doctor doctor : allDoctor) {
      if (doctor.getId() == id) {
        return doctor;
      }
    }
    return null;
  }

  @Override
  public void delete(int doctorId) {
    Doctor doctorToDelete = getDoctorById(doctorId);
    if (doctorToDelete != null) {
      getDao().delete(doctorToDelete);
    }
  }

}

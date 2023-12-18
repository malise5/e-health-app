package com.malise.app.bean;

import javax.ejb.Remote;

import com.malise.app.model.entity.Doctor;

@Remote
public interface DoctorBeanI extends GenericBeanI<Doctor> {

  Doctor getDoctorById(int id);

  void delete(int doctorId);

}

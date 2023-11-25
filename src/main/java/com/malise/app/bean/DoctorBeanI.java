package com.malise.app.bean;

import javax.ejb.Remote;

import com.malise.app.model.entity.Doctor;

@Remote
public interface DoctorBeanI extends GenericBeanI<Doctor> {

  // List<Doctor> getListOfDoctors();

  // String getDoctorTableHTML(); // only this

  // Doctor addDoctors(Doctor doctor);

  // void deleteDoctor(Doctor account);

}

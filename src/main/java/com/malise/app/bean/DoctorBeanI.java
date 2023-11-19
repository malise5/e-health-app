package com.malise.app.bean;

import com.malise.app.model.entity.Doctor;

public interface DoctorBeanI extends GenericBeanI<Doctor> {

  // List<Doctor> getListOfDoctors();

  String getDoctorTableHTML(); // only this

  // Doctor addDoctors(Doctor doctor);

  // void deleteDoctor(Doctor account);

}

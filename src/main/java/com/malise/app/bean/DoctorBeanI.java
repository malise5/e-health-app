package com.malise.app.bean;

import com.malise.app.model.entity.Doctor;

public interface DoctorBeanI {

  String chartOfDoctors();

  // List<Doctor> list();

  Doctor addDoctors(Doctor doctor);

  // Doctor addDoctors(Doctor doctor) throws Exception;

  void deleteDoctor(Doctor account);

}

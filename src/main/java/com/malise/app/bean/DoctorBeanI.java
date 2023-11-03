package com.malise.app.bean;

import com.malise.app.model.Doctor;

public interface DoctorBeanI {

  String chartOfDoctors();

  Doctor addDoctors(Doctor doctor) throws Exception;

  void deleteDoctor(Doctor account);

}

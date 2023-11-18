package com.malise.app.bean;

import java.util.List;

import com.malise.app.model.entity.Doctor;

public interface DoctorBeanI {

  List<Doctor> getListOfDoctors();

  String getDoctorTableHTML();

  Doctor addDoctors(Doctor doctor);

  void deleteDoctor(Doctor account);

}

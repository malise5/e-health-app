package com.malise.app.bean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.malise.app.model.entity.Doctor;
import com.malise.app.model.entity.Patient;

@Stateless
@Remote
public class PatientBean extends GenericBean<Patient> implements PatientBeanI {

  @Override
  public void add(Patient patient) {

    if (patient == null) {
      throw new RuntimeException("Invalid doctor details");
    }
    if (patient.getDoctorId() == null) {
      throw new RuntimeException(" doctor is required ");
    }

    if (patient.getDoctorId() == null) {
      throw new RuntimeException(" doctor is required ");
    }

    Doctor doctor = getDao().getEm().find(Doctor.class, patient.getDoctorId());

    if (doctor == null) {
      throw new RuntimeException("Invalid cusomer details");
    }

    patient.setDoctor(doctor);

    getDao().add(patient);

  }

  @Override
  public Patient getPatientID(int id) {
    List<Patient> allPatient = getDao().getList(new Patient());

    for (Patient patient : allPatient) {
      if (patient.getId() == id) {
        return patient;
      }
    }

    return null;
  }

}

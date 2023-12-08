package com.malise.app.bean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.malise.app.model.entity.Patient;

@Stateless
@Remote
public class PatientBean extends GenericBean<Patient> implements PatientBeanI {

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

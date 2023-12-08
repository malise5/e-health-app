package com.malise.app.bean;

import javax.ejb.Remote;

import com.malise.app.model.entity.Patient;

@Remote
public interface PatientBeanI extends GenericBeanI<Patient> {

  Patient getPatientID(int id);

}

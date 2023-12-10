package com.malise.app.bean;

import javax.ejb.Remote;

import com.malise.app.model.entity.Appointment;

@Remote
public interface AppointmentBeanI extends GenericBeanI<Appointment> {

  Appointment getAppointmentId(int id);

}

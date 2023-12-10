package com.malise.app.bean;

import java.util.List;

import com.malise.app.model.entity.Appointment;

public class AppointmentBean extends GenericBean<Appointment> implements AppointmentBeanI {

  @Override
  public Appointment getAppointmentId(int id) {
    List<Appointment> allAppointment = getDao().getList(new Appointment());
    for (Appointment appointment : allAppointment) {
      if (appointment.getId() == id) {
        return appointment;
      }
    }
    return null;
  }

}

package com.malise.app.utils;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

import com.malise.app.bean.DoctorBeanI;
import com.malise.app.model.entity.Doctor;

@Produces
@ApplicationScoped
public class Selector implements Serializable {

  @EJB
  private DoctorBeanI doctorBean;

  public List<Doctor> doctors() {
    return doctorBean.getList(new Doctor());
  }

}

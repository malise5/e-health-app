package com.malise.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.malise.app.model.entity.Doctor;
import com.malise.app.model.entity.Ward;
import com.malise.app.utils.WardCapacity;

@Stateless
@Remote
public class WardBean extends GenericBean<Ward> implements WardBeanI {
  @Inject
  private WardCapacity wardcapacity;

  // overiding
  @Override // add or update
  public void add(Ward ward) {

    ward.setCapacity(wardcapacity.capacityNo());
    getDao().add(ward);
  }

}

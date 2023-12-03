package com.malise.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import com.malise.app.model.entity.Ward;
import com.malise.app.utils.WardCapacity;
import com.malise.app.utils.WardMaxCap;

@Stateless
@Remote
public class WardBean extends GenericBean<Ward> implements WardBeanI {

  @Inject
  // @WardMaxCap
  @Named("maximumCapacity")
  private WardCapacity wardcapacity;

  // overiding
  @Override // add or update
  public void add(Ward ward) {

    ward.setCapacity(wardcapacity.capacityNo());
    getDao().add(ward);
  }

}

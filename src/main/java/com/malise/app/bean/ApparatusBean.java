package com.malise.app.bean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.malise.app.model.entity.Apparatus;


@Stateless
@Remote
public class ApparatusBean extends GenericBean<Apparatus> implements ApparatusBeanI {

  @Override // add or update
  public void add(Apparatus apparatus) {
    if (apparatus.getApparatusName() == null) {
      throw new RuntimeException("Name needed");
    }
    getDao().add(apparatus);
  }

}

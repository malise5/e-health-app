package com.malise.app.bean;

import java.util.List;

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

  @Override
  public Apparatus getApparatusByID(int id) {
    List<Apparatus> allApparatus = getDao().getList(new Apparatus());
    for (Apparatus apparatus : allApparatus) {
      if (apparatus.getId() == id) {
        return apparatus;
      }
    }
    return null;
  }

  @Override
  public void delete(int apparatusId) {
    Apparatus apparatusToDelete = getApparatusByID(apparatusId);

    if (apparatusToDelete != null) {
      getDao().delete(apparatusToDelete);
    }
  }

}

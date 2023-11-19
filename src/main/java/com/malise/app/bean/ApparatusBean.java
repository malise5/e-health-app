package com.malise.app.bean;

import java.io.Serializable;
import java.util.List;

import com.malise.app.model.entity.Apparatus;
import com.malise.app.view.html.HtmlComponent;
import com.malise.database.Database;

public class ApparatusBean extends GenericBean<Apparatus> implements ApparatusBeanI, Serializable {

  // @Override
  // public List<Apparatus> getListOfApparatus() {
  // return Database.getDbInstance().getApparatus();
  // }

  @Override
  public String getApparatusTableHTML() {
    List<Apparatus> apparatus = getList(Apparatus.class);
    return HtmlComponent.table(apparatus);
  }

  // @Override
  // public Apparatus addApparatus(Apparatus apparatus) {
  // Database database = Database.getDbInstance();
  // database.getApparatus().add(apparatus);
  // return apparatus;
  // }

  // @Override
  // public void deleteApparatus(Apparatus apparatus) {

  // }

}

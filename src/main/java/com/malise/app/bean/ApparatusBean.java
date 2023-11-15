package com.malise.app.bean;

import java.io.Serializable;

import com.malise.app.model.entity.Apparatus;
import com.malise.app.view.html.HtmlComponent;
import com.malise.database.Database;

public class ApparatusBean implements ApparatusBeanI, Serializable {

  @Override
  public String chartOfApparatus() {
    return HtmlComponent.table(Database.getDbInstance().getApparatus());
  }

  @Override
  public Apparatus addApparatus(Apparatus apparatus) {
    Database database = Database.getDbInstance();
    database.getApparatus().add(apparatus);
    return apparatus;
  }

  @Override
  public void deleteApparatus(Apparatus apparatus) {

  }

}

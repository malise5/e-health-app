package com.malise.app.bean;

import java.io.Serializable;
import java.util.List;

import com.malise.app.model.entity.Ward;
import com.malise.app.view.html.HtmlComponent;
import com.malise.database.Database;

public class WardBean implements WardBeanI, Serializable {

  @Override
  public List<Ward> getListOfWArd() {
    return Database.getDbInstance().getWard();
  }

  @Override
  public String getWardTableHTML() {
    List<Ward> ward = getListOfWArd();
    return HtmlComponent.table(ward);
  }

  @Override
  public Ward addWard(Ward ward) {
    Database database = Database.getDbInstance();

    database.getWard().add(ward);

    return ward;
  }

  @Override
  public void deleteWard(Ward ward) {

  }

}

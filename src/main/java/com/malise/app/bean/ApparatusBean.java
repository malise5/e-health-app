package com.malise.app.bean;

// import java.io.Serializable;
// import java.util.List;

import com.malise.app.model.entity.Apparatus;
// import com.malise.app.view.html.HtmlComponent;
// import com.malise.database.Database;

public class ApparatusBean extends GenericBean<Apparatus> implements ApparatusBeanI {

  // @Override
  // public String getApparatusTableHTML() {
  // List<Apparatus> apparatus = getList(Apparatus.class);
  // return HtmlComponent.table(apparatus);
  // }

  @Override // add or update
  public void add(Apparatus apparatus) {
    if (apparatus.getApparatusName() == null) {
      throw new RuntimeException("Name needed");
    }
    getDao().add(apparatus);
  }

}

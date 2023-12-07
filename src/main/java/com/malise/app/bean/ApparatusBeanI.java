package com.malise.app.bean;

import com.malise.app.model.entity.Apparatus;

public interface ApparatusBeanI extends GenericBeanI<Apparatus> {

  // String getApparatusTableHTML();

  Apparatus getApparatusByID(int id);

}

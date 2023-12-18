package com.malise.app.bean;

import com.malise.app.model.entity.Apparatus;

public interface ApparatusBeanI extends GenericBeanI<Apparatus> {

  Apparatus getApparatusByID(int id);

  void delete(int apparatusId);

}

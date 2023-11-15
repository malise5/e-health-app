package com.malise.app.bean;

import com.malise.app.model.entity.Apparatus;

public interface ApparatusBeanI {

  String chartOfApparatus();

  Apparatus addApparatus(Apparatus apparatus);

  void deleteApparatus(Apparatus apparatus);

}

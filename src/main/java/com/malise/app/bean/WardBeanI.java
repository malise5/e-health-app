package com.malise.app.bean;

import com.malise.app.model.entity.Ward;

public interface WardBeanI {

  String chartofWards();

  Ward addWard(Ward ward);

  void deleteWard(Ward ward);

}

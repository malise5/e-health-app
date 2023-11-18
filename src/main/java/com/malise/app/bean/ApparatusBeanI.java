package com.malise.app.bean;

import java.util.List;

import com.malise.app.model.entity.Apparatus;

public interface ApparatusBeanI {

  List<Apparatus> getListOfApparatus();

  String getApparatusTableHTML();

  Apparatus addApparatus(Apparatus apparatus);

  void deleteApparatus(Apparatus apparatus);

}

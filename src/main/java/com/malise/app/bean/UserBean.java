package com.malise.app.bean;

import java.io.Serializable;

import com.malise.app.model.entity.User;
import com.malise.database.Database;

public class UserBean implements UserBeanI, Serializable {

  Database database = Database.getDbInstance();

  @Override
  public boolean register(User user) {

    if (user.getPassword().equals(user.getConfirm_password())) {
      database.getData().add(new User(200L, user.getUsername(), user.getPassword()));

      return true;
    }

    return false;
  }

  @Override
  public boolean unRegister(User user) {

    return true;
  }

}

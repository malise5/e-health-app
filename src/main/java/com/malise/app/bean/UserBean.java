package com.malise.app.bean;

import java.sql.SQLException;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.malise.app.model.entity.User;

@Stateless
@Remote
public class UserBean extends GenericBean<User> implements UserBeanI {

  @Override
  public boolean register(User user) throws SQLException {

    if (!user.getPassword().equals(user.getConfirm_password())) {
      throw new RuntimeException("Password & confirm password do not match");
    }

    // 1. check if username already exist
    // 2. hash password
    // 3. initiate event to send email ...Observer design pattern

    getDao().add(user);
    return false;
  }

  @Override
  public boolean unRegister(User user) {

    return true;
  }

}

package com.malise.app.bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.malise.app.model.entity.User;
import com.malise.app.utils.EncryptSha256;
import com.malise.app.utils.EncryptTextI;

@Stateless
@Remote
public class UserBean extends GenericBean<User> implements UserBeanI {

  @Inject
  private EncryptTextI hashText;

  @Override
  public boolean register(User user) throws SQLException {

    if (!user.getPassword().equals(user.getConfirm_password())) {
      throw new RuntimeException("Password & confirm password do not match");
    }

    // List<User> existingUsers = getList(User.class);
    // if (!existingUsers.isEmpty()) {
    // throw new RuntimeException("User Already exists");
    // }

    try {
      user.setPassword(hashText.hash(user.getPassword()));
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }

    getDao().add(user);
    return false;
  }

  @Override
  public boolean unRegister(User user) {

    return true;
  }

}

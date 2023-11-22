package com.malise.app.bean;

// import java.io.Serializable;
// import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.malise.app.model.entity.User;
// import com.malise.database.MysqlDb;

public class UserBean extends GenericBean<User> implements UserBeanI {

  // Database database = Database.getDbInstance();

  @Override
  public boolean register(User user) throws SQLException {

    // if (user.getPassword().equals(user.getConfirm_password())) {

    // MysqlDb.insert(user);

    // return true;
    // }

    // return false;

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

package com.malise.app.bean;

import java.io.Serializable;

import com.malise.app.model.entity.User;
import com.malise.database.Database;

public class AuthBean implements AuthBeanI, Serializable {

  Database database = Database.getDbInstance();

  public User authenticate(User loginUser) {

    // User userDetails = null;

    // for (User user : database.getUsers()) {
    // if (loginUser.getUsername().equals(user.getUsername()) &&
    // loginUser.getPassword().equals(user.getPassword())) {
    // userDetails = user;

    // break;

    // }

    // }

    // return userDetails;

    return (User) database.getData(User.class)
        .stream()
        .filter(user -> ((User) user).getUsername().equals(loginUser.getUsername())
            && ((User) user).getPassword().equals(loginUser.getPassword()))
        .findAny()
        .orElse(null);
  }

}

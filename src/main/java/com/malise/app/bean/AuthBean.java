package com.malise.app.bean;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import com.malise.app.model.entity.User;
import com.malise.database.Database;

public class AuthBean implements AuthBeanI, Serializable {

  Database database = Database.getDbInstance();

  public User authenticate(User loginUser) {

    User userDetails = null;

    for (User user : database.getUsers()) {
      if (loginUser.getUsername().equals(user.getUsername()) && loginUser.getPassword().equals(user.getPassword())) {
        userDetails = user;

        break;

      }

    }

    return userDetails;
  }

}

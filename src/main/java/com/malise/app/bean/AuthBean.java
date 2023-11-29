package com.malise.app.bean;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.malise.app.model.entity.User;
import com.malise.app.utils.HashText;
import com.malise.database.MysqlDb;

@Stateless
@Remote
public class AuthBean implements AuthBeanI, Serializable {

  // Database database = Database.getDbInstance();
  @EJB
  MysqlDb database;

  @Inject
  private HashText hashText;

  public User authenticate(User loginUser) throws SQLException {

    // if (database == null) {
    // System.out.println("=======================================================================");
    // System.out.println("===========================No database
    // passing============================================");
    // System.out.println("=======================================================================");
    // }

    try {
      loginUser.setPassword(hashText.hash(loginUser.getPassword()));
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    System.out.println("=======================================================================");
    System.out.println(loginUser.getPassword());
    System.out.println("=======================================================================");

    PreparedStatement statement = database.getConnection()
        .prepareStatement("SELECT id,username from users WHERE username=? and password=?");

    statement.setString(1, loginUser.getUsername());
    statement.setString(2, loginUser.getPassword());

    ResultSet result = statement.executeQuery();

    User user = new User();

    while (result.next()) {
      user.setId(result.getLong("id"));
      user.setUsername(result.getString("username"));

      System.out.println("=======================================================================");

      System.out.println(result.getLong("id"));
      System.out.println(result.getString("username"));
      System.out.println("=======================================================================");

    }

    return user;

  }

}

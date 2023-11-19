package com.malise.app.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.malise.app.model.entity.User;
import com.malise.database.MysqlDb;

public class UserBean implements UserBeanI, Serializable {

  // Database database = Database.getDbInstance();

  @Override
  public boolean register(User user) throws SQLException {

    if (user.getPassword().equals(user.getConfirm_password())) {
      // MysqlDb database =

      // database.getData().add(new User(200L, user.getUsername(),
      // user.getPassword()));

      // Connection conn = database.getConnection();

      // Create a PreparedStatement with parameterized SQL
      PreparedStatement statement = MysqlDb.getInstance().getConnection()
          .prepareStatement("INSERT INTO users(id, username, password) VALUES (?, ?, ?)");

      // Generated random number
      int randomId = (int) (Math.random() * 1000);

      // Set values for the placeholders
      statement.setInt(1, randomId);
      statement.setString(2, user.getUsername());
      statement.setString(3, user.getPassword());

      statement.executeUpdate();

      return true;
    }

    return false;
  }

  @Override
  public boolean unRegister(User user) {

    return true;
  }

}

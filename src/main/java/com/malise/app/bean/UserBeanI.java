package com.malise.app.bean;

import java.sql.SQLException;

import com.malise.app.model.entity.User;

public interface UserBeanI extends GenericBeanI<User> {

  boolean register(User user) throws SQLException;

  boolean changePassword(User user) throws SQLException;

  boolean unRegister(User user);

}

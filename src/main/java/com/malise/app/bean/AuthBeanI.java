package com.malise.app.bean;

import java.sql.SQLException;

import com.malise.app.model.entity.User;

public interface AuthBeanI {

  User authenticate(User loginUser) throws SQLException;

}

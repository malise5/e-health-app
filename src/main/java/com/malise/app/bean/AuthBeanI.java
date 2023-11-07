package com.malise.app.bean;

import com.malise.app.model.entity.User;

public interface AuthBeanI {

  User authenticate(User loginUser);

}

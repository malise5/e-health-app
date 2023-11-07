package com.malise.app.bean;

import com.malise.app.model.entity.User;

public interface UserBeanI {

  boolean register(User user);

  boolean unRegister(User user);

}

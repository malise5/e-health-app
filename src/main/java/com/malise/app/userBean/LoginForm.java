package com.malise.app.userBean;

import java.io.Serializable;

public class LoginForm implements Serializable {

  private String usernamePlaceHolder = "Enter Username 😇 ";

  private String passwordPlaceHolder = "Enter Password";

  public String getUsernamePlaceHolder() {
    return usernamePlaceHolder;
  }

  public void setUsernamePlaceHolder(String usernamePlaceHolder) {
    this.usernamePlaceHolder = usernamePlaceHolder;
  }

  public String getPasswordPlaceHolder() {
    return passwordPlaceHolder;
  }

  public void setPasswordPlaceHolder(String passwordPlaceHolder) {
    this.passwordPlaceHolder = passwordPlaceHolder;
  }

}

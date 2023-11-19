package com.malise.app.model.entity;

import java.io.Serializable;

import com.malise.database.helper.DbTable;
import com.malise.database.helper.DbTableColumn;

@DbTable(nameOfTable = "users")
public class User implements Serializable {

  @DbTableColumn(name = "id", defination = "int")
  private Long id;

  @DbTableColumn(name = "username")
  private String username;

  @DbTableColumn(name = "password")
  private String password;

  private String confirm_password;

  public User() {
  }

  public User(Long id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirm_password() {
    return confirm_password;
  }

  public void setConfirm_password(String confirm_password) {
    this.confirm_password = confirm_password;
  }

}

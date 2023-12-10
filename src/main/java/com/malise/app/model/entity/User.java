package com.malise.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

// import com.malise.database.helper.DbTable;
// import com.malise.database.helper.DbTableColumn;

// @DbTable(nameOfTable = "users")
@Entity
@Table(name = "users")
public class User extends BaseEntity {

  // @DbTableColumn(name = "id", defination = "int")
  // private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Transient
  private String confirm_password;

  @Transient
  private String oldpassword;

  public User() {
  }

  public User(Long id, String username, String password) {
    // this.id = id;
    setId(id);
    this.username = username;
    this.password = password;
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
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

  public String getOldpassword() {
    return oldpassword;
  }

  public void setOldpassword(String oldpassword) {
    this.oldpassword = oldpassword;
  }

}

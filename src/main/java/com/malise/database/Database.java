package com.malise.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.malise.app.model.entity.Doctor;
import com.malise.app.model.entity.User;

public class Database implements Serializable {

  private String databaseCreateAt;

  private List<User> users = new ArrayList<>();

  private List<Doctor> doctor = new ArrayList<>();

  private static Database dbInstance;

  private Database() {
  }

  public static Database getDbInstance() {
    if (dbInstance == null) {
      dbInstance = new Database();
    }

    return dbInstance;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public List<Doctor> getDoctor() {
    return doctor;
  }

  public void setDoctor(List<Doctor> doctor) {
    this.doctor = doctor;
  }

  public String getDatabaseCreateAt() {
    return databaseCreateAt;
  }

}

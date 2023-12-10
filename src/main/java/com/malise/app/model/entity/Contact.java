package com.malise.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contact {

  @Column(name = "phone_number")
  private String phoneNo;

  private String country;

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

}

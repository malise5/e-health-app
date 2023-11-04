package com.malise.app.model.view;

import java.io.Serializable;

public class MenuLink implements Serializable {

  private String url;
  private String label;

  private MenuLinkStatus status;

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public MenuLinkStatus getStatus() {
    return status;
  }

  public void setStatus(MenuLinkStatus status) {
    this.status = status;
  }

}

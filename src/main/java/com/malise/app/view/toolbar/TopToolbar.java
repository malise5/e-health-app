package com.malise.app.view.toolbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.malise.app.model.view.MenuLink;
import com.malise.app.model.view.MenuLinkStatus;

public class TopToolbar implements Menu, Serializable {

  private String menu;

  private int activeLink;

  private final List<MenuLink> links = new ArrayList<>();

  {
    // links.add(new MenuLink("./home", "Home", MenuLinkStatus.NOT_ACTIVE));
    links.add(new MenuLink("./home", "Doctor", MenuLinkStatus.ACTIVE));
    links.add(new MenuLink("./ward", "Ward", MenuLinkStatus.NOT_ACTIVE));
    links.add(new MenuLink("./apparatus", "Apparatus", MenuLinkStatus.NOT_ACTIVE));
    links.add(new MenuLink("./logout", "Logout", MenuLinkStatus.NOT_ACTIVE));
  }

  // @Override
  // public String menu(int activeLinkIndex) {
  // this.activateLink(activeLinkIndex);

  // String menuBar = "<ul class=\"nav-links\">";

  // for (MenuLink link : links)
  // menuBar += "<li><a " + (link.getStatus() == MenuLinkStatus.ACTIVE ?
  // "class=\"active\"" : "")
  // + " href=\"" + link.getUrl() + "\">" + link.getLabel() + "</a></li>";

  // menuBar += "</ul>";

  // return menuBar;
  // }

  public String getMenu() {
    this.activateLink(getActiveLink());

    String menuBar = "<ul class=\"nav-links\">";

    for (MenuLink link : links)
      menuBar += "<li><a " + (link.getStatus() == MenuLinkStatus.ACTIVE ? "class=\"active\"" : "")
          + " href=\"" + link.getUrl() + "\">" + link.getLabel() + "</a></li>";

    menuBar += "</ul>";

    return menuBar;
  }

  public void setMenu(String menu) {
    this.menu = menu;
  }

  private void activateLink(int linkIndex) {
    for (int index = 0; index < links.size(); index++) {
      if (index == linkIndex)
        links.get(index).setStatus(MenuLinkStatus.ACTIVE);
      else
        links.get(index).setStatus(MenuLinkStatus.NOT_ACTIVE);
    }

  }

  public List<MenuLink> getLinks() {
    return links;
  }

  public int getActiveLink() {
    return activeLink;
  }

  public void setActiveLink(int activeLink) {
    this.activeLink = activeLink;
  }

  @Override
  public String menu(int activeLinkIndex) {
    return null;
  }

}

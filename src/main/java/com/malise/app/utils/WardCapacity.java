package com.malise.app.utils;

import javax.inject.Named;

@Named("maximumCapacity")
public class WardCapacity implements WardMaxI {
  public int capacityNo() {
    return 20;
  }
}

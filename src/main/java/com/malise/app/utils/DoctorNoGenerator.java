package com.malise.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Named;

@Named("DoctorNumber")
// @DoctorNo
public class DoctorNoGenerator implements DoctorNoI {

  private static final String PREFIX = "MYLNH";

  @Override
  public String generate() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");

    // Append customer identifier and a random number
    return PREFIX + "-KENY" + "-" + dateFormat.format(new Date()) + "-"
        + ThreadLocalRandom.current().nextInt(1000, 2000 + 1);
  }

}

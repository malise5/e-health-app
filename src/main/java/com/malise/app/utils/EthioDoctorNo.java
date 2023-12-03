package com.malise.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.inject.Specializes;

@Specializes
public class EthioDoctorNo extends DoctorNoGenerator {

  private static final String PREFIX = "MYLNH";

  @Override
  public String generate() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");

    // Append customer identifier and a random number
    return PREFIX + "-Eth" + "-" + dateFormat.format(new Date()) + "-"
        + ThreadLocalRandom.current().nextInt(1000, 2000 + 1);
  }
}

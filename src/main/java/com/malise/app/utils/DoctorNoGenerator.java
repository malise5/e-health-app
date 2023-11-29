package com.malise.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class DoctorNoGenerator {

  private static final String PREFIX = "MYLNH";

  public String generate(String customerId) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");

    // Append customer identifier and a random number
    return PREFIX + customerId + "-" + dateFormat.format(new Date()) + "-"
        + ThreadLocalRandom.current().nextInt(1000, 2000 + 1);
  }

}

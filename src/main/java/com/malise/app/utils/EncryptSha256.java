package com.malise.app.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;

@Priority(50)
@Alternative
public class EncryptSha256 implements EncryptTextI {

  public String hash(String text) {
    MessageDigest messageDigest;
    try {
      messageDigest = MessageDigest.getInstance("SHA-256");
      messageDigest.update(text.getBytes());

      return new String(messageDigest.digest());
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return text;
  }
}
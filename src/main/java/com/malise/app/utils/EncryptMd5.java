package com.malise.app.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;

@Priority(100)
@Alternative
public class EncryptMd5 implements EncryptTextI {

  @Override
  public String hash(String password) {

    String encryptedpassword = null;

    try {
      MessageDigest md5 = MessageDigest.getInstance("MD5");

      md5.update(password.getBytes());

      byte[] bytes = md5.digest();

      StringBuilder s = new StringBuilder();
      for (int i = 0; i < bytes.length; i++) {
        s.append(Integer.toString((bytes[i] & 0xFF) + 0x100, 16).substring(1));
      }

      encryptedpassword = s.toString();

    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return encryptedpassword;
  }

}

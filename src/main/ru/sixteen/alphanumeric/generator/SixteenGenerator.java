//Copyright 2022 Denis Protopopov
//Licensed under the Apache License, Version 2.0 (the «License»);

package ru.sixteen.alphanumeric.generator;

public class SixteenGenerator {

  private final String AZaz09_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  private final String FIRST_VALUE = "AAAAAAAAAAAAAAAA";
  private final String LAST_VALUE  = "9999999999999999";

  private String id;
  private int c_pos = 16;

  public String next() {
    if (id == null || "".equals(id) || id.length() < 16) {
      id = FIRST_VALUE;
      return id;
    }
    if (LAST_VALUE.equals(id)) {
      return FIRST_VALUE;
    }
    inc(c_pos-1);
    return id;
  }

  private void inc(int pos) {
    if (id.charAt(pos) == AZaz09_CHARACTERS.charAt(AZaz09_CHARACTERS.length()-1)) {
      inc(pos-1);
    }
    id = id.substring(0,pos) + nextChar(id.charAt(pos)) + id.substring(pos+1,16);
  }

  private char nextChar(char c) {
    if (c == AZaz09_CHARACTERS.charAt(AZaz09_CHARACTERS.length()-1)) {
      return AZaz09_CHARACTERS.charAt(0);
    } else {
      return AZaz09_CHARACTERS.charAt(AZaz09_CHARACTERS.indexOf(c)+1);
    }
  }

  public static SixteenGenerator getInstance() {
    return new SixteenGenerator();
  }

  public static SixteenGenerator getInstance(String initValue) {
    return new SixteenGenerator(initValue);
  }

  private SixteenGenerator() {
    this.id = FIRST_VALUE;
  }

  private SixteenGenerator(String initValue) {
    this.id = initValue;
  }

}

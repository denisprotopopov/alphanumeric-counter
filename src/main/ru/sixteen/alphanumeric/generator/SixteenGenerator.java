//Copyright 2022 Denis Protopopov
//Licensed under the Apache License, Version 2.0 (the «License»);

package ru.sixteen.alphanumeric.generator;

public class SixteenGenerator {

  private final String AZaz09_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  private final String AZaz09_FIRST_VALUE = "AAAAAAAAAAAAAAAA";
  private final String AZaz09_LAST_VALUE = "9999999999999999";

  private String id;
  private String id_init_value;
  private String id_first_value;
  private String id_last_value;
  private int id_length;
  private String sequence_characters;

  /**
  / Get value
  / */
  public String next() {
    if (id == null || "".equals(id) || id.length() < this.id_length) {
      id = id_init_value;
      return this.id;
    }
    if (this.id_last_value.equals(id)) {
      id = id_first_value;
      return this.id;
    }
    inc(id_length-1);
    return this.id;
  }

  private void inc(int pos) {
    if (id.charAt(pos) == sequence_characters.charAt(sequence_characters.length()-1)) {
      inc(pos-1);
    }
    id = id.substring(0,pos) + nextChar(id.charAt(pos)) + id.substring(pos+1, this.id_length);
  }

  private char nextChar(char c) {
    if (c == sequence_characters.charAt(sequence_characters.length()-1)) {
      return sequence_characters.charAt(0);
    } else {
      return sequence_characters.charAt(sequence_characters.indexOf(c)+1);
    }
  }

  /**
   * Get Instance witch start from default value 'AAAAAAAAAAAAAAAA'
   * @return
   */
  public static SixteenGenerator getInstance() {
    return new SixteenGenerator();
  }

  /**
   * Get Instance which start from custom value
   * If lenght of value < 16 start from default value
   * @param initValue
   * @return
   */
  public static SixteenGenerator getInstance(String initValue) {
    return new SixteenGenerator(initValue);
  }

  public static SixteenGenerator getInstance(String initValue, String firstValue, String lastValue, String sequence_characters) {
    return new SixteenGenerator(initValue, firstValue, lastValue, sequence_characters);
  }

  private SixteenGenerator() {
    this.id = AZaz09_FIRST_VALUE;
    this.id_init_value = AZaz09_FIRST_VALUE;
    this.id_first_value = AZaz09_FIRST_VALUE;
    this.id_last_value = AZaz09_LAST_VALUE;
    this.id_length = AZaz09_FIRST_VALUE.length();
    this.sequence_characters = AZaz09_CHARACTERS;
  }

  private SixteenGenerator(String initValue) {
    if (initValue == null) {
      throw new NullPointerException("sequence_characters is null");
    }
    if (initValue.length() > 16 || initValue.length() < 16) {
      throw new IllegalArgumentException("length of initValue must be 16");
    }
    this.id = initValue;
    this.id_init_value = initValue;
    this.id_first_value = AZaz09_FIRST_VALUE;
    this.id_last_value = AZaz09_LAST_VALUE;
    this.id_length = initValue.length();
    this.sequence_characters = AZaz09_CHARACTERS;
    checkInitValueAndSequence(id_init_value);
  }

  private SixteenGenerator(String initValue, String firstValue, String lastValue, String sequence_characters) {
    if (sequence_characters == null) {
      throw new NullPointerException("sequence_characters is null");
    }
    if (sequence_characters.length() < 1) {
      throw new IllegalArgumentException("sequence_characters is empty. must consists of at least 1 char");
    }
    this.sequence_characters = sequence_characters;

    if (initValue == null) {
      throw new NullPointerException("initValue is null");
    }
    if (initValue.length() == 0) {
      throw new IllegalArgumentException("initValue is empty. must consists of at least 1 char");
    }
    this.id = initValue;
    this.id_length = initValue.length();
    this.id_last_value = lastValue;
    this.id_first_value = firstValue;
    checkInitValueAndSequence(this.id_first_value);
    checkInitValueAndSequence(this.id_last_value);
    checkInitValueAndSequence(this.id);
  }

  private void checkInitValueAndSequence(String value) {
    for(char c : value.toCharArray()) {
      if(this.sequence_characters.indexOf(c) < 0) {
        throw new IllegalArgumentException("initValue contains char [" + c + "] that do not present in sequence_characters '" + sequence_characters + "'");
      }
    }
  }

}

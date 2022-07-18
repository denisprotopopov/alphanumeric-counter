package ru.sixteen.alphanumeric.generator;

public class Test {

  public static void main(String[] args) {
    SixteenGenerator generator = SixteenGenerator.getInstance();
    while(true) {
      System.out.println(generator.next());
    }
  }
}

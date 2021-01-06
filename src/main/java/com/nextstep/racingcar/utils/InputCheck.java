package com.nextstep.racingcar.utils;

public class InputCheck {

  public static boolean isValidName(String input) {
    if (!isAlphabet(input)) {
      throw new RuntimeException("Name should contain only alphabets");
    }
    return true;
  }

  private static boolean isAlphabet(String input) {
    return input.matches("[a-zA-Z]+");
  }
}

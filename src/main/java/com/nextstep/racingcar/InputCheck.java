package com.nextstep.racingcar;

public class  InputCheck {

  public static boolean checkName(String input) {
      if (!isAllowedInput(input)) {
          throw new RuntimeException();
      }
    return true;
  }

  private static boolean isAllowedInput(String input) {
    return input.matches("[a-zA-Z]{1,5}");
  }
}

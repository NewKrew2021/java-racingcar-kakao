package com.nextstep.racingcar;

public class InputCheck {

  public static boolean checkName(String input) {
      if (!isAllowedInput(input)) {
          throw new RuntimeException();
      }
    return true;
  }

  private static boolean isAllowedInput(String input) {
    return !isOverMaxLength(input) && isAlpha(input);
  }

  private static boolean isOverMaxLength(String input) {
    return input.length() > 5;
  }

  private static boolean isAlpha(String input) {
    return input.matches("[a-zA-Z]+");
  }
}

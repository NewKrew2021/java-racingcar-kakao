package com.nextstep.racingcar.domain;

public class InputCheck {

  private InputCheck() {}

  public static boolean checkName(String input) {
      if (!isAllowedInput(input)) {
          throw new IllegalArgumentException("부적절한 자동차 이름");
      }
    return true;
  }

  private static boolean isAllowedInput(String input) {
    return input.matches("[a-zA-Z]{1,5}");
  }
}

package com.nextstep.racingcar.ui;

import com.nextstep.racingcar.utils.InputCheck;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

  private final static Scanner SC = new Scanner(System.in);

  public static String[] scanCarNames() {
    String[] names = carNames();

    for (String name : names) {
      checkNameIsValid(name);
    }
    return names;
  }

  public static int scanRepeatCount() {
    int repeatCount = repeatCount();
    checkCountIsValid(repeatCount);
    return repeatCount;
  }

  private static void checkNameIsValid(String name) {
    if (!InputCheck.isValidName(name)) {
      String message = String.format("Name: %s is invalid.", name);
      throw new RuntimeException(message);
    }
  }

  private static String[] carNames() {
    String namesInput = SC.next();
    return namesInput.split(",");
  }

  private static int repeatCount() {
    int count;

    try {
      count = SC.nextInt();
    } catch (InputMismatchException e) {
      throw new RuntimeException(e);
    }

    return count;
  }

  private static void checkCountIsValid(int repeatCount) {
    if (isNegative(repeatCount)) {
      throw new RuntimeException("Repeat count should be positive");
    }
  }

  private static boolean isNegative(int value) {
    return value < 0;
  }
}

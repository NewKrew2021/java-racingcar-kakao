package com.nextstep.racingcar.ui;

import com.nextstep.racingcar.utils.InputCheck;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
  private final Scanner SC = new Scanner(System.in);

  public String[] getCarNames() {
    String[] names = scanCarNames();

    for (String name : names) {
      checkNameIsValid(name);
    }
    return names;
  }

  public int getRepeatCount() {
    int repeatCount = scanRepeatCount();
    checkCountIsValid(repeatCount);
    return repeatCount;
  }

  private void checkNameIsValid(String name) {
    if (!InputCheck.isValidName(name)) {
      String message = String.format("Name: %s is invalid.", name);
      throw new RuntimeException(message);
    }
  }

  private String[] scanCarNames() {
    String namesInput = SC.next();
    return namesInput.split(",");
  }

  private int scanRepeatCount() {
    int count;

    try {
      count = SC.nextInt();
    } catch(InputMismatchException e) {
      throw new RuntimeException(e);
    }

    return count;
  }

  private void checkCountIsValid(int repeatCount) {
    if (isNegative(repeatCount)) {
      throw new RuntimeException("Repeat count should be positive");
    }
  }

  private boolean isNegative(int value) {
    return value < 0;
  }
}

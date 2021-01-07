package com.nextstep.racingcar.domain;

import java.security.SecureRandom;

public class Utils {

  private static final int UPPERBOUND = 10;

  private static final SecureRandom rand = new SecureRandom();

  public static int getRandomInt() {
    return rand.nextInt(UPPERBOUND);
  }

}

package com.nextstep.racingcar.domain;

import java.util.Random;

public class Utils {

  private static final int UPPERBOUND = 10;

  public static int getRandomInt() {
    Random random = new Random();
    return random.nextInt(UPPERBOUND);
  }

}

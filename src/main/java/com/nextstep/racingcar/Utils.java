package com.nextstep.racingcar;

import java.util.Random;

public class Utils {

  public static int getRandomInt() {
    Random random = new Random();
    return random.nextInt(10);
  }

}

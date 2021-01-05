package com.nextstep.racingcar.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomDigitsGenerator {

  public static List<Integer> getNRandomDigitsForCars(int n) {
    return new Random()
        .ints(n)
        .boxed()
        .map(num -> num % 10)
        .collect(Collectors.toList());
  }
}

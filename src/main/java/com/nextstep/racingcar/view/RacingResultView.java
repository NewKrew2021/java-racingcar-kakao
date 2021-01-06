package com.nextstep.racingcar.view;

import com.nextstep.racingcar.domain.Car;
import com.nextstep.racingcar.domain.Cars;

public class RacingResultView {

  private RacingResultView() {
  }

  public static void printRaceResultMessage() {
    System.out.println("경기 결과");
  }

  public static void printCar(Car car) {
    System.out.println(String.format("%s : %s", car.getName(), "-".repeat(car.getLocation())));
  }

  public static void printCars(Cars cars) {
    for (Car car: cars.getCars()) {
      printCar(car);
    }
    System.out.println();
  }

  public static void printWinners(Cars cars) {
    System.out.println(String.join(", ", cars.getWinners()) + "가 최종 우승했습니다.");
  }
}

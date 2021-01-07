package com.nextstep.racingcar.view;

import com.nextstep.racingcar.domain.CarInfo;
import com.nextstep.racingcar.domain.CarsInfo;
import java.util.List;

public class RacingResultView {

  private RacingResultView() {
  }

  public static void printRaceResultMessage() {
    System.out.println("경기 결과");
  }

  public static void printCar(CarInfo carInfo) {
    System.out
        .println(String.format("%s : %s", carInfo.getName(), "-".repeat(carInfo.getLocation())));
  }

  public static void printCars(CarsInfo carsInfo) {
    for (CarInfo carInfo: carsInfo.getCars()) {
      printCar(carInfo);
    }
    System.out.println();
  }

  public static void printWinners(List<String> winners) {
    System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
  }
}

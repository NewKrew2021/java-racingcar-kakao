package com.nextstep.racingcar.view;

import com.nextstep.racingcar.domain.CarInfo;
import com.nextstep.racingcar.domain.CarsInfo;
import java.util.List;
import java.util.stream.Collectors;

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

  public static void printWinners(CarsInfo carsInfo) {
    String winners = String.join(", ", getCarNames(carsInfo));
    System.out.println(winners + "가 최종 우승했습니다.");
  }

  private static List<String> getCarNames(CarsInfo carsInfo) {
    return carsInfo.getCars()
        .stream()
        .map(CarInfo::getName)
        .collect(Collectors.toList());
  }
}

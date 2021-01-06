package com.nextstep.racingcar.views;

import com.nextstep.racingcar.domain.Car;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

  private final String CAR_UNIT_STEP_SYMBOL = "-";

  public void printResultGuide() {
    System.out.println("실행 결과");
  }

  public void printSimulationResults(List<Car> cars) {
    for (Car car : cars) {
      printCarStatus(car);
    }

    System.out.println("");
  }

  public void printWinners(List<Car> winners) {
    String winnersAppended = winners.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));

    System.out.println(String.format("%s가 최종 우승했습니다.", winnersAppended));
  }

  private void printCarStatus(Car car) {
    String status = String.format("%s : %s",
        car.getName(),
        String.join(
            "",
            Collections.nCopies(car.getLocation(), CAR_UNIT_STEP_SYMBOL)
        ));

    System.out.println(status);
  }
}
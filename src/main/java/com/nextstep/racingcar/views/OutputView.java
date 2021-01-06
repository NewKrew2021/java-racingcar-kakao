package com.nextstep.racingcar.view;

import com.nextstep.racingcar.domain.Car;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

  private final String CAR_UNIT_STEP_SYMBOL = "-";

  public void printRequestCarNames() {
    printer("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분).");
  }

  public void printRequestRepeatCount() {
    printer("시도할 회수는 몇회인가요?");
  }

  public void printResultGuide() {
    printer("실행 결과");
  }

  public void printSimulationResults(List<Car> cars) {
    for (Car car : cars) {
      printCarStatus(car);
    }

    printer("");
  }

  public void printWinners(List<Car> winners) {
    String winnersAppended = winners.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));

    printer(String.format("%s가 최종 우승했습니다.", winnersAppended));
  }

  private void printCarStatus(Car car) {
    String status = String.format("%s : %s",
        car.getName(),
        String.join(
            "",
            Collections.nCopies(car.getLocation(), CAR_UNIT_STEP_SYMBOL)
        ));

    printer(status);
  }

  private void printer(String message) {
    System.out.println(message);
  }
}

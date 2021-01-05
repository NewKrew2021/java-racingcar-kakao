package com.nextstep.racingcar.ui;

import com.nextstep.racingcar.racingcar.Car;
import com.nextstep.racingcar.racingcar.Racingcar;
import java.util.Collections;
import java.util.List;

public class MessagePrinter {

  public static void printRequestCarNames() {
    printer("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분).");
  }

  public static void printRequestRepeatCount() {
    printer("시도할 회수는 몇회인가요?");
  }

  public static void printResultGuide() {
    printer("실행 결과");
  }

  public static void printSimulationResults(Racingcar racingcar) {
    List<Car> cars = racingcar.getCars();

    for (Car car : cars) {
      printCarStatus(car);
    }

    System.out.println();
  }

  public static void printWinners(List<String> winners) {
    String winnersAppended = String.join(", ", winners);
    String message = String.format("%s가 최종 우승했습니다.", winnersAppended);

    printer(message);
  }

  private static void printer(String message) {
    System.out.println(message);
  }
  
  private static void printCarStatus(Car car) {
    String status = String.format("%s : %s",
        car.getName(),
        String.join("", Collections.nCopies(car.getLocation(), "-")));
    System.out.println(status);
  }
}

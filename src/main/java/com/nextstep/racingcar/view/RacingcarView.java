package com.nextstep.racingcar.view;

import com.nextstep.racingcar.domain.Racingcar;
import java.util.Scanner;

public class RacingcarView {

  Scanner sc;
  Racingcar racingcar;

  public RacingcarView(Racingcar racingcar) {
    sc = new Scanner(System.in);
    this.racingcar = racingcar;
  }

  public String inputCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    return sc.nextLine();
  }

  public int inputRepetitionCount() {
    System.out.println("시도할 회수는 몇회인가요?");
    return sc.nextInt();
  }

  public void printRaceResultMessage() {
    System.out.println("경기 결과");
  }

  public void printCars() {
    System.out.println(racingcar.toString());
  }

  public void printWinners() {
    System.out.println(String.join(", ", racingcar.getWinners()) + "가 최종 우승했습니다.");
  }
}

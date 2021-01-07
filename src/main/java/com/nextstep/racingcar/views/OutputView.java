package com.nextstep.racingcar.views;

import com.nextstep.racingcar.domain.Cars;

public class OutputView {
    public void printResultGuide() {
        System.out.println("실행 결과");
    }

    public void printSimulationResults(Cars cars) {
        System.out.println(cars.getCarsStatus());
    }

    public void printWinners(Cars winners) {
        System.out.println(String.format("%s가 최종 우승했습니다.", winners.getNamesAppended()));
    }
}

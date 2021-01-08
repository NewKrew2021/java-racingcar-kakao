package com.nextstep.racingcar.views;

import com.nextstep.racingcar.domain.Cars;

import java.util.Collections;

public class OutputView {
    private final String CAR_UNIT_STEP_SYMBOL = "-";

    public void printResultGuide() {
        System.out.println("실행 결과");
    }

    public void printSimulationResults(Cars cars) {
        StringBuilder message = new StringBuilder();

        cars.delegate(car -> message.append(car.getName())
                .append(" : ")
                .append(String.join("",
                        Collections.nCopies(car.getLocation(), CAR_UNIT_STEP_SYMBOL)))
                .append(System.lineSeparator()));

        System.out.println(message);
    }

    public void printWinners(Cars winners) {
        StringBuilder winnersAppendedByComma = new StringBuilder();

        winners.delegate(winner -> {
            if (winnersAppendedByComma.length() > 0) {
                winnersAppendedByComma.append(", ")
                        .append(winner.getName());

                return;
            }

            winnersAppendedByComma.append(winner.getName());
        });

        System.out.printf("%s가 최종 우승했습니다.\n", winnersAppendedByComma.toString());
    }
}

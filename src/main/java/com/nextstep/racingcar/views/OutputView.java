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
        StringBuilder message = new StringBuilder();

        for (Car car : cars) {
            message.append(car.getName())
                    .append(" : ")
                    .append(String.join("",
                            Collections.nCopies(car.getLocation(), CAR_UNIT_STEP_SYMBOL)))
                    .append(System.lineSeparator());
        }

        System.out.println(message);
    }

    public void printWinners(List<Car> winners) {
        String winnersAppendedByComma = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(String.format("%s가 최종 우승했습니다.", winnersAppendedByComma));
    }
}

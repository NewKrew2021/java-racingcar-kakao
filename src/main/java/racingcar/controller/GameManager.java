package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.stream.Collectors;

public class GameManager {
    private static Cars cars;

    public static void main(String[] argv) {
        cars = new Cars(InputView.inputCarNames());
        Round round = new Round(InputView.inputRound());

        startRound(round);
        ResultView.printWinner(getWinner());
    }

    private static void startRound(Round round) {
        ResultView.printRoundStart();

        for (int i = 0; i < round.getRound(); i++) {
            cars.move();
            ResultView.print(roundResult());
        }
    }

    private static String roundResult() {
        String roundResult = "";
        for (Car car : cars.getCars()) {
            roundResult += car.getName()
                    + " : "
                    + new String(new char[car.getLocation()]).replace("\0", "_")
                    + "\n";
        }
        return roundResult;
    }

    private static String getWinner() {
        return cars.getCars().stream()
                .filter(car -> car.getLocation() == getWinnerLocation())
                .map(Car::getName)
                .collect(Collectors.joining(" "));
    }

    private static int getWinnerLocation() {
        return cars.getCars().stream()
                .mapToInt(car -> car.getLocation())
                .max().orElse(0);
    }

}

package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.GameView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameManager {

    private final GameView gameView = new GameView();
    private final Scanner sc = new Scanner(System.in);

    public void startGame() {

        gameView.printStartPhrase();
        String carString = getCarString();
        Cars cars = new Cars(makeCarList(parsing(carString)));
        gameView.printAskRoundPhrase();
        int round;
        while ((round = getRoundNumber()) == -1) {
            gameView.printErrorInputPhrase();
        }
        executeRound(cars, round);
        List<String> winners = cars.getWinners();
        gameView.gameResult(winners);
    }

    public List<String> parsing(String userInput) throws RuntimeException {

        String[] carNames = userInput.split(",");
        return Arrays.stream(carNames)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<Car> makeCarList(List<String> carNames) {

        List<Car> cars = new ArrayList<Car>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private void executeRound(Cars cars, Integer rounds) {

        for (int i = 0; i < rounds; i++) {
            cars.moveCars();
            gameView.roundResult(cars);
        }
    }

    private int getRoundNumber() {

        try {
            int round = sc.nextInt();
            return validateRoundNumber(round);
        } catch (Exception e) {
            sc.nextLine();
            return -1;
        }
    }

    public int validateRoundNumber(int round) {
        if (round > 0) {
            return round;
        }
        return -1;
    }

    public String getCarString() {

        String carString = sc.nextLine();
        while (!validateCarString(carString)) {
            gameView.printErrorInputPhrase();
            carString = sc.nextLine();
        }
        return carString;
    }

    public boolean validateCarString(String carString) {

        if (carString == null || carString.length() == 0) {
            return false;
        }
        return true;
    }

}

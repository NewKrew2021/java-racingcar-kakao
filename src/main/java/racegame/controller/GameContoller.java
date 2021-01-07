package racegame.controller;

import racegame.domain.Car;
import racegame.domain.Cars;
import racegame.domain.Winners;
import racegame.util.RandomUtil;
import racegame.view.GameView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameContoller {

    public void startGame() {
        Scanner sc = new Scanner(System.in);

        GameView.gameStartMessageView();
        String carString = sc.nextLine();
        Cars cars = makeCars(carString);

        GameView.gameRoundMessage();
        int round = sc.nextInt();

        GameView.roundTitleView();
        runEachRound(cars, round);

        Winners winner = cars.getWinners();
        GameView.gameResultView(winner);
    }

    private Cars makeCars(String userInput) {
        return new Cars(Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    private void runEachRound(Cars cars, Integer rounds) {
        IntStream.range(0, rounds)
                .forEach(round -> singleRoundJobs(cars));
    }

    private void singleRoundJobs(Cars cars) {
        cars.allCarMoves(RandomUtil.getRandomValue());
        GameView.roundResultView(cars);
    }

}

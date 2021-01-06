package racegame;

import racegame.domain.Car;
import racegame.domain.Cars;
import racegame.domain.Winners;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameManager {

    private final GameView gameView = new GameView();
    private final Scanner sc = new Scanner(System.in);

    public void startGame() {
        gameView.gameStartMessageView();
        String carString = sc.nextLine();
        Cars cars = makeCars(carString);

        gameView.gameRoundMessage();
        int round = sc.nextInt();

        gameView.roundTitleView();
        executeRound(cars, round);

        Winners winner = cars.getWinners();
        gameView.gameResultView(winner);
    }

    public Cars makeCars(String userInput) {
        return new Cars(Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public void executeRound(Cars cars, Integer rounds) {
        for (int i = 0; i < rounds; i++) {
            cars.allCarMoves();
            gameView.roundResultView(cars);
        }
    }

}

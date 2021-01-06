package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameManager {

    private final GameView gameView = new GameView();
    private final Scanner sc = new Scanner(System.in);

    public void startGame() {

        gameView.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carString = sc.nextLine();
        gameView.print("시도할 회수는 몇회인가요?");
        int round = sc.nextInt();

        Cars cars = new Cars(makeCarList(parsing(carString)));
        executeRound(cars, round);

        List<Car> winner = cars.getWinners();
        gameView.gameResult(winner);
    }

    public List<String> parsing(String userInput) throws RuntimeException {

        String[] carNames = userInput.split(",");
        return Arrays.stream(carNames)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<Car> makeCarList(List<String> carNames) {

        List<Car> cars = new ArrayList<Car>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public void executeRound(Cars cars, Integer rounds) {

        for (int i = 0; i < rounds; i++) {
            cars.moveCars();
            gameView.roundResult(cars);
        }
    }


}

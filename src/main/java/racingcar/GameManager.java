package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class GameManager {

    private final GameView gameView = new GameView();
    private final Scanner sc = new Scanner(System.in);

    public void startGame() {

        gameView.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carString = sc.nextLine();
        gameView.print("시도할 회수는 몇회인가요?");
        int round = sc.nextInt();

        List<Car> cars = makeCarList(parsing(carString));
        executeRound(cars, round);

        List<Car> winner = getWinners(cars);
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

    public void executeRound(List<Car> cars, Integer rounds) {

        for (int i = 0; i < rounds; i++) {
            carMove(cars);
            gameView.roundResult(cars);
        }
    }

    public List<Car> getWinners(List<Car> cars) {

        List<Car> winners = new ArrayList<Car>();
        Collections.sort(cars);
        Car firstPlaceCar = cars.get(0);
        int index = 0;
        while (firstPlaceCar.isEqualPosition(cars.get(index))) {
            winners.add(cars.get(index++));
        }
        return winners;
    }

    private void carMove(List<Car> cars) {

        for (Car car : cars) {
            car.goForward(RandomUtil.getRandomValue());
        }
    }
}

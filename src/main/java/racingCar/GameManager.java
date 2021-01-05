package racingCar;

import java.util.*;
import java.util.stream.Collectors;

public class GameManager {

    private final GameView gameView = new GameView();
    private final Scanner sc = new Scanner(System.in);

    public void startGame() {
        // 입력 받아서 자동차 생성
        gameView.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carString = sc.nextLine();
        gameView.print("시도할 회수는 몇회인가요?");
        int round = sc.nextInt();

        // 게임 실행
        List<Car> cars = makeCarList(parsing(carString));
        executeRound(cars, round);

        List<Car> winner = getWinner(cars);
        gameView.gameResult(winner);
    }

    public List<String> parsing(String userInput) throws RuntimeException {
        String[] split = userInput.split(",");
        return Arrays.stream(split)
                .map(String::trim)
                .map(this::isLong)
                .collect(Collectors.toList());
    }

    public String isLong(String carName) {

        if (carName.length() > 5) {
            throw new RuntimeException("이름이 너무 깁니다");
        }
        return carName;
    }


    public List<Car> makeCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
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
        List<Car> winners = getWinner(cars);

    }

    public List<Car> getWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();

        Collections.sort(cars);
        Car first = cars.get(0);
        int index = 0;
        while (first.equalPosition(cars.get(index))) {
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

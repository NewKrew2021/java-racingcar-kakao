package racingCar;

import java.util.*;
import java.util.stream.Collectors;

public class GameManager {

    private final GameView gameView = new GameView();
    private final Scanner sc = new Scanner(System.in);

    public void startGame() {
        // 입력 받아서 자동차 생성
        gameView.gameStartMessageView();
        String carString = sc.nextLine();
        gameView.gameRoundMessage();
        int round = sc.nextInt();

        // 게임 실행
        gameView.roundTitleView();
        List<Car> cars = makeCarList(parsing(carString));
        executeRound(cars, round);

        // 우승자 출력
        List<Car> winner = getWinner(cars);
        gameView.gameResultView(winner);
    }

    public List<String> parsing(String userInput) throws RuntimeException {
        String[] split = userInput.split(",");
        return Arrays.stream(split)
                .map(String::trim)
                .map(this::throwExceptionWhenNameIsLong)
                .collect(Collectors.toList());
    }

    public String throwExceptionWhenNameIsLong(String carName) {
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
            gameView.roundResultView(cars);
        }
    }

    private void carMove(List<Car> cars) {
        for (Car car : cars) {
            car.goForward(RandomUtil.getRandomValue());
        }
    }

    public List<Car> getWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(e -> e.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public Integer getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

}

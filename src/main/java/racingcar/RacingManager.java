package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {
    private int time;
    private Racing racing;

    public RacingManager(int time, Racing racing) {
        this.time = time;
        this.racing = racing;
    }

    public void race() {
        System.out.println("\n실행 결과");
        RandomGenerator randomGenerator = new RandomGenerator();

        while (time-- > 0) {
            racing.moveAll(randomGenerator.generate(racing.getCars().size()));
            printDistance();
        }

        printWinner();
    }

    public void printDistance() {
        for (int i = 0; i < racing.getCars().size(); i++) {
            Car car = racing.getCars().get(i);
            String distance = new String(new char[car.getDistance()]).replace("\0", "-");
            System.out.println(car.getName() + " : " + distance);
        }

        System.out.println();
    }

    public void printWinner() {
        List<Car> winners = racing.getWinners();
        String winnerString = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winnerString + "가 최종 우승했습니다.");
    }
}

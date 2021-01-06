package racingcar.view;

import racingcar.domain.RacingGame;
import racingcar.domain.CarInfo;

import java.util.List;
import java.util.Scanner;

public class RacingGameView {

    private static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GET_ITER_NO_MESSAGE = "시도할 회수는 몇회인가요?";
    private Scanner sc;

    public RacingGameView() {
        this.sc = new Scanner(System.in);
    }

    public String getCarNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println(GET_CAR_NAMES_MESSAGE);
        String carNames = sc.nextLine();

        return carNames;
    }

    public int getIterNo() {
        int iterationNumber;
        System.out.println(GET_ITER_NO_MESSAGE);
        iterationNumber = sc.nextInt();
        return iterationNumber;
    }

    public void printStatus(List<CarInfo> carInfos) {
        for (CarInfo carInfo : carInfos) {
            System.out.println(carInfo);
        }
        System.out.println();
    }

    public void printResult(RacingGame racingGame) {
        List<String> winnerNames = racingGame.findWinners();
        printStatus(racingGame.getCarInfos());
        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }
}

package racingcar;

import java.util.List;
import java.util.Scanner;

public class Circuit {
    private static RacingGame racingGame;
    private static int time;

    public static void main(String[] args) {
        Circuit circuit = new Circuit();
        circuit.opening();
        circuit.start();
        circuit.end();
    }

    public void opening() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.nextLine();
        racingGame = new RacingGame(carNames);
        System.out.println("시도할 회수는 몇회인가요?");
        time = sc.nextInt();
    }

    public void start() {
        for (int i = 0; i < time; i++) {
            printStatus(racingGame.racing());
        }
    }

    public void printStatus(List<CarInfo> carInfos) {
        for (CarInfo carInfo : carInfos) {
            System.out.println(carInfo);
        }
        System.out.println();
    }

    public void end() {
        List<String> winnerNames = racingGame.findWinners();
        printStatus(racingGame.getStatus());
        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }
}

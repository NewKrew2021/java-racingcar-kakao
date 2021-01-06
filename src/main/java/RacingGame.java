import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {
    private final int FINAL_ROUND;
    private static final int MAX_LENGTH = 5;
    private final Cars cars;
    private int curRound;

    public RacingGame(int finalRound, Cars cars) {
        this.FINAL_ROUND = finalRound;
        this.cars = cars;
        this.curRound = 0;
    }

    public boolean isEnd() {
        return curRound == FINAL_ROUND;
    }

    public void playRound() {
        cars.play();
        curRound++;
    }

    public Cars getWinners() {
        return cars.getWinners();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = sc.nextLine().split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int roundNo = sc.nextInt();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        RacingGame game = new RacingGame(roundNo, new Cars(cars));

        System.out.println("실행 결과");
        while (!game.isEnd()) {
            game.playRound();
            System.out.println();
        }

        System.out.println(game.getWinners() + "가 최종 우승하셨습니다.");
    }
}

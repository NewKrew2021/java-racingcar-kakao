import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {
    private final int ROUND_NO;
    private final List<Car> cars;
    private static final int MAX_LENGTH = 5;
    private int curRound;

    public RacingGame(int roundNo, List<Car> cars) {
        this.ROUND_NO = roundNo;
        this.cars = cars;
        this.curRound = 0;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public void printWinners() {
        List<Car> winners = getWinners();
        String[] winnersName = new String[winners.size()];

        for (int i = 0; i < winnersName.length; ++i) {
            winnersName[i] = winners.get(i).getName();
        }

        System.out.println(String.join(", ", winnersName) + "가 최종 우승했습니다.");
    }

    public boolean isEnd() {
        return curRound == ROUND_NO;
    }

    public void playRound() {
        MyRandom random = new MyRandom();
        for (Car car : cars) {
            car.run(random.nextInt());
            car.print();
        }
        curRound++;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private static boolean isValidNames(String[] names) {
        List<String> nameList = Arrays.asList(names);
        return nameList.stream()
                .noneMatch(name -> name.length() > MAX_LENGTH);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] carNames;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            carNames = sc.nextLine().split(",");
        } while (!isValidNames(carNames));

        System.out.println("시도할 회수는 몇회인가요?");
        int roundNo = sc.nextInt();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        RacingGame game = new RacingGame(roundNo, cars);

        System.out.println("실행 결과");
        while (!game.isEnd()) {
            game.playRound();
            System.out.println();
        }

        game.printWinners();
    }
}

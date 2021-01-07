package racinggame;

import domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class RacingGame {
    public static InputManager inputManager;
    public static UserInputValidator nameInputValidator;
    public static UserInputValidator countInputValidator;

    static final String COMMENT_CAR_NAMES_INPUT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    static final String COMMENT_HOWMANY_INPUT = "시도할 회수는 몇회인가요?";
    static final String COMMENT_RESULT = "실행 결과";

    static {
        inputManager = new InputManager();
        countInputValidator = (String str) -> {
            if (str == null)
                throw new Exception();
            int num = Integer.parseInt(str);
            if (num <= 0)
                throw new Exception();
        };
        nameInputValidator = (String stringFromUser) -> {
            String namesArray[] = stringFromUser.split(",");
            for (int i = 0; i < namesArray.length; i++) {
                new Car(namesArray[i]);
            }
        };
    }

    public void play() {
        Cars cars = new Cars(getCarsFromUser());
        int tryCount = getCountFromUser();
        Consumer<Cars> printCars = (Cars cs) -> {
            cs.printAll();
            System.out.println();
        };
        moveCars(cars, tryCount, printCars);
        printHeads(cars);
    }

    public List<Car> getCarsFromUser() {
        List<Car> carsFromUser = Arrays.asList(inputManager.getFromUser(
                COMMENT_CAR_NAMES_INPUT,
                nameInputValidator
        )
                .split(","))
                .stream()
                .map((String carName) -> new Car(carName))
                .collect(Collectors.toList());
        return carsFromUser;
    }

    public int getCountFromUser() {
        return Integer.parseInt(inputManager.getFromUser(COMMENT_HOWMANY_INPUT, countInputValidator));
    }

    public void moveCars(Cars cars, int tryCount, Consumer<Cars> afterMove) {
        System.out.println(COMMENT_RESULT);
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(RandomBasedMoveStrategy.getInstance());
            afterMove.accept(cars);
        }
    }

    public void printHeads(Cars cars) {
        List<Car> heads = cars.getHeads();
        String headsStr = "";
        for (int i = 0; i < heads.size() - 1; i++) {
            headsStr += heads.get(i).getName() + ", ";
        }
        headsStr += heads.get(heads.size() - 1).getName();
        System.out.println(headsStr + "가 최종 우승했습니다");
    }
}

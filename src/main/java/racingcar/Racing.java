package racingcar;

import java.util.*;

public class Racing {

    private final Cars cars;
    private final int round;

    public Racing(String names, int round) {
        this.cars = new Cars(registerCars(splitNames(names)));
        this.round = round;
    }

    private List<Car> registerCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private List<String> splitNames(String str) {
        return new ArrayList<>(Arrays.asList(str.split(",")));
    }

    public void race() {
        cars.printCurrentStatus();
        for (int i = 0; i < round; i++) {
            cars.moveOneRepeat();
            cars.printCurrentStatus();
        }
        printWinnerName(cars.winnerNames());
    }

    private void printWinnerName(List<String> names) {
        System.out.print(String.join(",", names));
        System.out.println("가 최종 우승했습니다.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racing racing = (Racing) o;
        return round == racing.round && Objects.equals(cars, racing.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, round);
    }
}

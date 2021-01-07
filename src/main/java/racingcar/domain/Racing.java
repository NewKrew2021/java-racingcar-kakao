package racingcar.domain;

import java.util.*;

public class Racing {

    private final Cars cars;
    private int round;

    public Racing(String names, int round) {
        this.cars = new Cars(registerCars(splitNames(names)));
        this.round = round;
    }

    public boolean isEnd() {
        return round == 0;
    }

    public void race() {
        spendOneRound();
        cars.moveOneRepeat();
        cars.printCurrentStatus();
    }

    public List<String> getWinnerNames() {
        return cars.winnerNames();
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

    private void spendOneRound() {
        this.round--;
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

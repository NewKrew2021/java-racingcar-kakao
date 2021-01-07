package racingcar.domain;

import java.util.*;

public class Racing {

    private final Cars cars;
    private final Round round;

    public Racing(String names, int round) {
        this.cars = new Cars(splitNames(names));
        this.round = new Round(round);
    }

    public boolean isFinish() {
        return round.isEndRound();
    }

    public void race() {
        round.spendOneRound();
        cars.moveOneRepeat(new RandomConditionValueStrategy());
    }

    public List<Car> getCarsMidTermStatus() {
        return cars.getCars();
    }

    public List<String> getWinnerNames() {
        return cars.winnerNames();
    }

    private List<String> splitNames(String str) {
        return new ArrayList<>(Arrays.asList(str.split(",")));
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

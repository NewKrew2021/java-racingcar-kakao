package racingcar.domain;

import java.util.*;

public class Racing {

    private final Cars cars;
    private final Round round;

    public Racing(String names, int round) {
        this.cars = new Cars(splitNames(names));
        this.round = new Round(round);
    }

    private List<String> splitNames(String str) {
        return new ArrayList<>(Arrays.asList(str.split(",")));
    }

    public boolean isFinish() {
        return round.isEndRound();
    }

    public void race(MoveDecisionStrategy moveDecisionStrategy) {
        round.spendOneRound();
        cars.move(moveDecisionStrategy);
    }

    public List<Car> getCarsMidTermStatus() {
        return cars.getCars();
    }

    public List<String> getWinnerNames() {
        return cars.winnerNames();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racing racing = (Racing) o;
        return Objects.equals(cars, racing.cars) && Objects.equals(round, racing.round);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, round);
    }
}

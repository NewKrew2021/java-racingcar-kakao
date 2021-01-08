package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(String input) {
        setUpCarName(input);
    }

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public RacingCars getWinners() {
        return new RacingCars(racingCars.stream().filter(racingCar -> racingCar.isSameDistance(getMaxDist())).collect(Collectors.toList()));
    }

    public void runRound() {
        for (RacingCar racingCar : racingCars) {
            racingCar.tryMove(new RandomMovingStrategy());
        }
    }

    private void setUpCarName(String input) {
        for (String name : input.split(",")) {
            racingCars.add(new RacingCar(name));
        }
    }

    private int getMaxDist() {
        int maxDistance = 0;
        for (RacingCar racingCar : racingCars) {
            maxDistance = racingCar.getLargerDistance(maxDistance);
        }
        return maxDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}

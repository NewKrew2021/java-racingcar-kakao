package racingcar.domain;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int DISTANCE_LIMIT = 10;

    private List<RacingCar> racingCars;
    private final CheckMovable checkMovable;

    public RacingCars(List<RacingCar> racingCars, CheckMovable checkMovable) {
        this.racingCars = racingCars;
        this.checkMovable = checkMovable;
    }

    public void run() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(checkMovable);
        }
    }

    private int getMaxDist() {
        return racingCars.stream()
                        .mapToInt(RacingCar::getDist)
                        .max()
                        .orElse(0);
    }

    public String getWinners() {
        return racingCars.stream()
                .filter(racingCar -> racingCar.getDist() == getMaxDist())
                .map(racingCar -> racingCar.getName())
                .collect(Collectors.joining(", "));
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void printRoundResult() {
        racingCars.forEach(RacingCar::printDist);
    }
}

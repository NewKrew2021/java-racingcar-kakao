package racingcar.domain;

import racingcar.util.CheckMovable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCars {
    private final List<RacingCar> racingCars;
    private final CheckMovable checkMovable;

    public RacingCars(List<RacingCar> racingCars, CheckMovable checkMovable) {
        this.racingCars = racingCars;
        this.checkMovable = checkMovable;
    }

    public RoundResult playRound() {
        Map<String, Integer> result = new HashMap<>();
        for (RacingCar racingCar : racingCars) {
            result.put(racingCar.getName(), racingCar.move(checkMovable));
        }
        return new RoundResult(result);
    }

    public String[] getWinners() {
        return racingCars.stream()
                .filter(racingCar -> racingCar.getDist() == getMaxDist())
                .map(RacingCar::getName)
                .toArray(String[]::new);
    }

    private int getMaxDist() {
        return racingCars.stream()
                        .mapToInt(RacingCar::getDist)
                        .max()
                        .orElse(0);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

}

package racingcar;

import racingcar.model.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int DISTANCE_LIMIT = 10;

    private final ArrayList<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(String input) {
        setUpCarName(input.split(","));
    }

    private void setUpCarName(String[] names) {
        for (String name : names) {
            racingCars.add(new RacingCar(name));
        }
    }

    public void run() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(makeRandomDist());
        }
    }

    private int makeRandomDist() {
        return (int) (Math.random() * DISTANCE_LIMIT);
    }

    private int getMaxDist() {
        return racingCars.stream()
                        .mapToInt(RacingCar::getDist)
                        .max()
                        .orElse(0);
    }

    public List<RacingCar> getWinners() {
        return racingCars.stream()
                .filter(racingCar -> racingCar.getDist() == getMaxDist())
                .collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void printRoundResult() {
        racingCars.forEach(RacingCar::printDist);
    }
}

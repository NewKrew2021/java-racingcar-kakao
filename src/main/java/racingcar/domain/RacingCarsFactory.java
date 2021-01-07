package racingcar.domain;

import racingcar.util.CheckMovable;
import racingcar.util.CheckMovableByRandomNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarsFactory {

    public static RacingCars randomNumberCars(String names) {
        return new RacingCars(makeCarsFromName(names.split(",")), new CheckMovableByRandomNumber());
    }

    private static List<RacingCar> makeCarsFromName(String[] names) {
        return Arrays.stream(names).map(RacingCar::new).collect(Collectors.toList());
    }

}

package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarsFactory {

    public static RacingCars from(String names, CheckMovable checkMovable) {
        return new RacingCars(makeCarsFromName(names.split(",")), checkMovable);
    }

    private static List<RacingCar> makeCarsFromName(String[] names) {
        return Arrays.stream(names).map(name -> new RacingCar(name)).collect(Collectors.toList());
    }

}

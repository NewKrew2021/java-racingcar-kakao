package RacingCar;

import RacingCar.Model.RacingCar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private ArrayList<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(String input) {
        setUpCarName(input);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    private void setUpCarName(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            racingCars.add(new RacingCar(name));
        }
    }

    public List<RacingCar> getWinners() {
        return racingCars.stream().filter(racingCar -> racingCar.getDist() == getMaxDist()).collect(Collectors.toList());
    }

    private int getMaxDist() {
        return racingCars.stream().mapToInt(RacingCar::getDist).max().orElse(0);
    }
}

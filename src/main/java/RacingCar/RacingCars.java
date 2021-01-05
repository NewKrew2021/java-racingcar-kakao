package RacingCar;

import RacingCar.Model.RacingCar;

import java.util.ArrayList;
import java.util.List;

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
}

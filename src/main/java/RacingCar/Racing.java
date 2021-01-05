package RacingCar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private ArrayList<RacingCar> racingCars;

    public Racing(String names) {
        racingCars = new ArrayList<>();
        for (String name : splitNames(names)) {
            racingCars.add(new RacingCar(name));
        }
    }

    public String[] splitNames(String input) {
        return input.split(",");
    }


    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}

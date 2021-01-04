package RacingCar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private ArrayList<RacingCar> racingCars;

    public Racing() {
        racingCars = new ArrayList<>();
    }

    public String[] splitNames(String input) {
        return input.split(",");
    }

    public void setRacingCars(String[] names) {
        for (String name : names) {
            racingCars.add(new RacingCar(name));
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}

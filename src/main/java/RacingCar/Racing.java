package RacingCar;

import java.util.ArrayList;

public class Racing {
    private ArrayList<RacingCar> racingCars;

    public Racing() {
        racingCars = new ArrayList<>();
    }

    public String[] splitNames(String input) {
        return input.split(",");
    }

    /*
    public void setNames(String input) {
        for (String name : splitNames(input)) {
            racingCars.add(new RacingCar(name));
        }
    }*/

}

package carRace;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winners {

    private final List<Car> cars;

    public Winners(List<Car> cars){
        this.cars = cars;
    }

    public List<String> getWinnersNames(){
        List<String> names = new ArrayList<>();
        for(Car car : cars){
            names.add(car.getName());
        }
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Winners)) return false;
        Winners winners = (Winners) o;
        return Objects.equals(cars, winners.cars);
    }
}

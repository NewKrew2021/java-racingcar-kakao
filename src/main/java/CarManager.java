import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> cars = new ArrayList<>();

    public void createCar(String name) {
        cars.add(new Car(name));
    }

    public List<Car> getCars() {
        return cars;
    }
}

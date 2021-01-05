import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<Car>();

    public Cars(String carNames){
        String[] names = carNames.split(",");
        for(String name : names){
            cars.add(new Car(name, 0));
        }
    }

    public int getCount(){
        return cars.size();
    }

    public void moveAll(){
        for(Car car : cars){
            car.move();
        }
    }
}

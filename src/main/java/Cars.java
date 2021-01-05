import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<Car>();

    public Cars(String carNames){
        String[] names = carNames.split(",");
        for(String name : names){
            cars.add(new Car(name, 0));
        }
    }

    public Cars(List<Car> cars){
        for(Car car : cars){
            this.cars.add(car);
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

    public void printPositions(){
        for(Car car : cars){
            car.printPosition();
        }
    }

    public List<Car> getHeads(){
        Collections.sort(cars);
        Car headCar = cars.get(0);
        return cars.stream()
                .filter(car -> car.isEqualPosition(headCar))
                .collect(Collectors.toList());
    }

    public void printHeads(){
        List<Car> heads = getHeads();
        for(int i=0; i<heads.size()-1; i++){
            heads.get(i).printName();
            System.out.print(",");
        }
        cars.get(heads.size()-1).printName();
    }
}

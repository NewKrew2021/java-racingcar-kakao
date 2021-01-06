package carRace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars fromNames(String[] names) {
        List<Car> newCars = new ArrayList<>();
        for (String name : names) {
            newCars.add(new Car(name));
        }
        return new Cars(newCars);
    }

    public void moveAllCars(List<Integer> numbers) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).judgeAndGo(numbers.get(i));
        }
    }

    public List<Car> getWinners() {
        Collections.sort(carList);
        Car maxCar = carList.get(0);
        return carList.stream()
                .filter(car -> car.compareTo(maxCar) == 0)
                .collect(Collectors.toList());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car).append("\n");
        }
        return sb.toString();
    }

    public int getNumOfCars() {
        return carList.size();
    }
}
package carRace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarSet {

    List<Car> carList;

    public CarSet(String[] names) {
        this.carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public void moveAllCars(List<Integer> numbers){
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).judgeAndGo(numbers.get(i));
        }
    }

    public List<Integer> getCarsRandomNumber(){
        Random rd = new Random();
        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < carList.size(); i++){
            numbers.add(rd.nextInt(10));
        }

        return numbers;
    }

    public List<Car> getWinners(){
        Collections.sort(carList);
        Car maxCar = carList.get(0);
        return carList.stream()
                .filter(car -> car.compareTo(maxCar) == 0)
                .collect(Collectors.toList());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car).append("\n");
        }
        return sb.toString();
    }
}
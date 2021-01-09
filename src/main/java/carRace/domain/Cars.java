package carRace.domain;

import carRace.dtos.CarDTO;
import carRace.dtos.CarDTOs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.max;

public class Cars {

    private static final int MINIMUM_LOCATION = 0; //TODO Loation 부분을 클래스로 새로 만든후, MINIMUM LOCATION을 반환하도록 해보자.
    private final List<Car> carList;

    public Cars(String[] names) {
        this.carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public Cars(List<Car> cars){
        carList = cars;
    }

    public void moveAllCars(List<Integer> numbers){
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).judgeAndGo(numbers.get(i));
        }
    }

    public Winners getWinners(){
        int maxLocation = MINIMUM_LOCATION;
        for (Car car : carList) {
            maxLocation = max(maxLocation, car.getLocation()) ;
        }

        int finalMaxLocation = maxLocation;
        List<Car> cars = carList.stream()
                .filter(car -> car.getLocation() == finalMaxLocation)
                .collect(Collectors.toList());
        return new Winners(cars);
    }

    public int size(){
        return carList.size();
    }

    public CarDTOs getCarInformations(){
        List<CarDTO> informations = new ArrayList<>();
        for(Car car : carList){
            informations.add(car.getDTO());
        }
        return new CarDTOs(informations);
    }
}
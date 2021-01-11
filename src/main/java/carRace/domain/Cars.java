package carRace.domain;

import carRace.dtos.CarDTO;
import carRace.dtos.CarDTOs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MINIMUM_LOCATION = 0;
    private final List<Car> carList;

    public Cars(String[] names) {
        this.carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    /* 이 생성자는 테스트 할때만 사용해야 합니다. */
    public Cars(List<Car> cars) {
        carList = cars;
    }

    public void moveAllCarsAccordingTo(List<Integer> movingNumbers) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).judgeAndGo(movingNumbers.get(i));
        }
    }

    public Winners getWinners() {
        int maxLocation = getMaxLocationInCars();

        List<Car> cars = carList.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .collect(Collectors.toList());
        return new Winners(cars);
    }

    private int getMaxLocationInCars() {
        int maxLocation = MINIMUM_LOCATION;

        for(Car car : carList){
            maxLocation = Math.max(maxLocation, car.getLocation());
        }

        return maxLocation;
    }

    public int size() {
        return carList.size();
    }

    public CarDTOs getCarInformations() {
        List<CarDTO> informations = new ArrayList<>();
        for(Car car : carList){
            informations.add(car.getDTO());
        }
        return new CarDTOs(informations);
    }
}
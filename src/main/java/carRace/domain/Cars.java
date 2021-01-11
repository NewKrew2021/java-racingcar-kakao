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

    public void moveAllCarsAccordingTo(MovingStrategy strategy) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).judgeAndGo(strategy);
        }
    }

    public List<String> getWinningCarNames() {
        int maxLocation = getMaxLocationInCars();

        return carList.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxLocationInCars() {
        return carList.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }

    public CarDTOs getCarInformations() {
        List<CarDTO> informations = new ArrayList<>();
        for(Car car : carList){
            informations.add(car.getDTO());
        }
        return new CarDTOs(informations);
    }

    public List<CarDTO> getCarInformationsAsList(){ //TODO: if it is not chosen, it has to be removed.
        List<CarDTO> informations = new ArrayList<>();
        for(Car car : carList){
            informations.add(car.getDTO());
        }
        return informations;
    }
}
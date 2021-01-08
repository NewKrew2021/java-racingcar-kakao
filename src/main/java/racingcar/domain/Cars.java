package racingcar.domain;

import racingcar.utils.RandomNumberForRacing;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carsList;

    public Cars(List<Car> cars) {
        this.carsList = cars;
    }

    public void moveAll() {
        for(Car car: carsList){
            car.move(RandomNumberForRacing.getRandomNumberForRacing());
        }
    }

    public List<Car> getCarsList(){
        return this.carsList;
    }

    public List<Car> getWinner() {
        int maxPosition = getMaxPosition();

        return carsList
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<String> getWinnerName(){
        return getWinner()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getMaxPosition() {
        return carsList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(java.util.NoSuchElementException::new);
    }
}

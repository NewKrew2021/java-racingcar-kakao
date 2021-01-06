package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carsList;

    public Cars(List<Car> cars) {
        this.carsList = cars;
    }

    public void moveAll() {
        for(Car car: carsList){
            car.move(new RandomNumber());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(carsList, cars1.carsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsList);
    }
}

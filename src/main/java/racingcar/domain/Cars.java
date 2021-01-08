package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        String[] parsingCarNames = splitCarNames(carNames);
        addCarName(parsingCarNames);
    }

    private String[] splitCarNames(String carNames) {
        return carNames
                .replace(" ", "")
                .split(",");
    }

    private void addCarName(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(new RandomNumberMoveStrategy());
        }
    }

    public String getRoundResult() {
        String roundResult = "";
        for (Car car : cars) {
            roundResult += car.getName()
                    + " : "
                    + new String(new char[car.getLocation()]).replace("\0", "_")
                    + "\n";
        }
        return roundResult;
    }

    public String getWinner() {
        int winnerLocation = getWinnerLocation();
        return getWinnerNames(winnerLocation);
    }

    private String getWinnerNames(int winnerLocation) {
        return cars.stream()
                .filter(car -> car.getLocation() == winnerLocation)
                .map(Car::getName)
                .collect(Collectors.joining(" "));
    }

    private int getWinnerLocation() {
        return cars.stream()
                .mapToInt(car -> car.getLocation())
                .max().orElse(0);
    }

}
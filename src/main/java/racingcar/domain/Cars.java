package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> carsList;

    public Cars(List<Car> cars) {
        this.carsList = cars;
    }

    public void moveAll(List<Integer> randomNumberList) {
        if (carsList.size() != randomNumberList.size()) {
            throw new IllegalArgumentException("차량을 움직이는 도중 잘못된 랜덤 리스트가 입력되었습니다.");
        }
        IntStream.range(0, carsList.size())
                .forEach(i ->
                        carsList.get(i).move(randomNumberList.get(i)));
    }

    public Map<String, Integer> getCarsInfo() {
        Map<String, Integer> result = new HashMap<>();
        for (Car car : carsList) {
            result.put(car.getName(), car.getPosition());
        }
        return result;
    }

    public int getNumberOfCars() {
        return this.carsList.size();
    }

    public List<String> getWinnerName() {
        return getWinner()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> getWinner() {
        int maxPosition = getMaxPosition();

        return carsList
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carsList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(java.util.NoSuchElementException::new);
    }
}

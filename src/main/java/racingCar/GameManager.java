package racingCar;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameManager {

    public GameManager() {
    }

    public List<String> parsing(String userInput) throws RuntimeException {
        String[] split = userInput.split(",");
        return Arrays.stream(split)
                     .map(String::trim)
                     .map(this::isLong)
                     .collect(Collectors.toList());
    }

    public String isLong(String carName){

        if(carName.length()>5){
            throw new RuntimeException("이름이 너무 깁니다");
        }
        return carName;
    }

    public List<Car> getWinner(List<Car> cars){
        List<Car> winners=new ArrayList<Car>();

        Collections.sort(cars);
        Car first=cars.get(0);
        int index=0;
        while(first.equalPosition(cars.get(index))) {
            winners.add(cars.get(index++));
        }
        return winners;
    }
    public List<Car> makeCarList(List<String> carNames){
        List<Car> cars=new ArrayList<Car>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public void executeRound(List<Car> cars, Integer rounds) {
        for (int i = 0; i < rounds; i++) {
            carMove(cars);
            // 라운드 출
        }
        List<Car> winners = getWinner(cars);

    }

    private void carMove(List<Car> cars) {
        for (Car car : cars) {
            car.goForward(RandomUtil.getRandomValue());
        }
    }
}

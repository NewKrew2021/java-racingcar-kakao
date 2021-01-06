package racing;

import exception.InvalidCarNameException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Racing {
    private static final Random random = new Random();
    private static final int NAME_LIMIT = 5;

    private final List<Car> cars;
    private int progressNumber;
    private int maxPosition;

    public Racing(String carNames, int progressNumber) {
        this.progressNumber = progressNumber;
        this.cars = Arrays.stream(carNames.split(","))
                .filter(this::checkValidCarName)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private boolean checkValidCarName(String carName) {
        if (carName.length() > NAME_LIMIT) {
            throw new InvalidCarNameException();
        }
        return carName.length() <= NAME_LIMIT;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    //TODO : 삭제되야할 메소드입니다.
    public List<Integer> repeatRacing() {
        while (progressNumber > 0) {
            this.race();
            this.setMaxPosition();
            this.getRaceString();
            progressNumber--;
        }
        return getPositions();
    }

    public void setMaxPosition() {
        cars.forEach(car -> maxPosition = Math.max(car.getPosition(), maxPosition));
    }

    private String getWinnerNameWithComma(Car car) {
        String s = "";
        if (car.getPosition() == this.maxPosition) {
            s += car.getName() + ", ";
        }
        return s;
    }

    public String returnWinnerString() {
        String s = cars.stream()
                .map(this::getWinnerNameWithComma)
                .reduce("", (total, value) -> total + value);
        return s.substring(0, s.length() - 2) + "가 최종 우승했습니다.";
    }

    public String getRaceString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList())
                .stream()
                .reduce("", (total, value) -> total + value + "\n");
    }

    //TODO : 삭제되야할 메소드 입니다.
    public List<Integer> getPositions() {
        List<Integer> result = new ArrayList<>();
        for (Car car : this.cars) {
            result.add(car.getPosition());
        }
        return result;
    }

    public void race() {
        cars.forEach(car -> car.move(car.goOrStop(makeRandomValue())));
    }

    private int makeRandomValue() {
        return random.nextInt(10);
    }

    public boolean isFinished() {
        return progressNumber > 0;
    }

    public void decreaseProgressNumber() {
        progressNumber--;
    }
}

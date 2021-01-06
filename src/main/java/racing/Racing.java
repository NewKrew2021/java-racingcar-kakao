package racing;

import exception.InvalidCarNameException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final Random random = new Random();

    private List<Car> cars;
    int progressNumber;
    int maxPosition;

    public Racing(String carNames, int progressNumber) {
        this.progressNumber = progressNumber;
        setCars(carNames);
    }

    public void setCars(String s) {
        List<String> names = Arrays.asList(s.split(","));
        if (!checkValidAllCarName(names)) {
            throw new InvalidCarNameException();
        }
        this.cars = new ArrayList<>();
        for (String name : names) {
            this.cars.add(new Car(name));
        }
    }

    private boolean checkValidAllCarName(List<String> nameArray) {
        int invalidCnt = 0;
        for (String name : nameArray) {
            invalidCnt += checkValidCarName(name) ? 0 : 1;
        }
        return invalidCnt == 0;
    }

    private boolean checkValidCarName(String carName) {
        return carName.length() <= 5;
    }

    public List<Car> getCars() {
        return this.cars;
    }

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
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
    }

    private String getWinnerNameWithComma(int carIndex) {
        String s = "";
        if (cars.get(carIndex).getPosition() == this.maxPosition) {
            s += cars.get(carIndex).getName() + ", ";
        }
        return s;
    }

    public String returnWinnerString() {
        String s = "";
        List<Integer> resultPosition = this.getPositions();
        for (int i = 0; i < resultPosition.size(); i++) {
            s += this.getWinnerNameWithComma(i);
        }
        s = s.substring(0, s.length() - 2);
        return s + "가 최종 우승했습니다.";
    }

    public String getRaceString() {
        String s = "";
        for (Car car : this.cars) {
            s += car + "\n";
        }
        return s;
    }

    public List<Integer> getPositions() {
        List<Integer> result = new ArrayList<>();
        for (Car car : this.cars) {
            result.add(car.getPosition());
        }
        return result;
    }

    public void race() {
        for (Car car : this.cars) {
            car.move(car.goOrStop(makeRandomValue()));
        }
    }

    private int makeRandomValue() {
        return random.nextInt(10);
    }

    public boolean isFinished(){
        return progressNumber > 0;
    }

    public void decreaseProgressNumber(){
        progressNumber--;
    }
}

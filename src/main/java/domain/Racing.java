package domain;


import java.util.Arrays;
import java.util.stream.Collectors;

public class Racing {

    private final Cars cars;
    private int progressNumber;

    public Racing(String carNames, int progressNumber) {
        this.progressNumber = progressNumber;
        this.cars = new Cars(
                Arrays.stream(carNames.split(","))
                        .map(Car::new)
                        .collect(Collectors.toList()));
    }

    public String getRaceString() {
        return cars.toString();
    }

    public void race() {
        cars.race();
    }

    public boolean isNotFinished() {
        return progressNumber > 0;
    }

    public void decreaseProgressNumber() {
        progressNumber--;
    }

    public String result() {
        return cars.returnWinnerString();
    }
}

package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    protected Cars cars;
    private TryNo tryNo;

    public RacingCarGame() {

    }

    public RacingCarGame(String text, int tryNo) {
        this.cars = new Cars(initGame(splitName(text)));
        this.tryNo = new TryNo(tryNo);
    }


    protected List<Car> initGame(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public void racingGame() {
        cars.moveAll();
        tryNo = tryNo.tryRacing();
    }

    public Cars getCars() {
        return cars;
    }

    protected String[] splitName(String text) {
        return text.split(",");
    }


    public Winners findWinners() {
        return cars.filterWinners();
    }

    public boolean isEnd() {
        return tryNo.isEnd();
    }
}

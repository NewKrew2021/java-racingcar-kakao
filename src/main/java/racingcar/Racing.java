package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> carList;

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(String s) {
        String[] carName = s.split(",");
        carList = new ArrayList<>();

        for (int i = 0; i < carName.length; i++) {
            carList.add(new Car(carName[i], 0));
        }
    }

    public int getMaxLength() {
        int maxLength = 0;

        for (int i = 0; i < carList.size(); i++) {
            maxLength = Integer.max(maxLength, carList.get(i).getName().length());
        }

        return maxLength;
    }

    public CarStatus goStop(int rand) {
        if (rand >= 4)
            return CarStatus.Go;

        return CarStatus.Stop;
    }

    public void moveAll() {
        for (int i = 0; i < carList.size(); i++) {
            CarStatus status = goStop(RandomNumber.generate());
            move(carList.get(i), status);
        }
    }

    public void move(Car car, CarStatus status) {
        if (status == CarStatus.Go)
            car.go();
    }
}

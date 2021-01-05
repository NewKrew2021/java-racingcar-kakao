package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public boolean isTooLong() {
        if (getMaxLength() > 5)
            return true;
        return false;
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
            carList.get(i).move(status);
        }
    }


    public Set<Car> getWinner() {
        Set<Car> winner = new HashSet<>();
        int maxDistance = getMaxDistance();

        for (int i = 0; i < carList.size(); i++) {
            addWinner(winner, carList.get(i), maxDistance);
        }

        return winner;
    }

    public int getMaxDistance() {
        int maxDistance = 0;

        for (int i = 0; i < carList.size(); i++) {
            maxDistance = Math.max(maxDistance, carList.get(i).getDistance());
        }

        return maxDistance;
    }

    public void addWinner(Set<Car> winner, Car car, int maxDistance) {
        if (car.getDistance() == maxDistance)
            winner.add(car);
    }
}

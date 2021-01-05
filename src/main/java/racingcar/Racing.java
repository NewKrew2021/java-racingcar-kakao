package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(String s) {
        String[] carName = s.split(",");
        cars = new ArrayList<>();

        for (int i = 0; i < carName.length; i++) {
            cars.add(new Car(carName[i], 0));
        }
    }

    public boolean isTooLong() {
        if (cars.stream().anyMatch(o1 -> o1.getName().length() > 5))
            return true;

        return false;
    }

    public CarStatus goStop(int rand) {
        if (rand >= 4)
            return CarStatus.Go;

        return CarStatus.Stop;
    }

    public void moveAll() {
        for (int i = 0; i < cars.size(); i++) {
            CarStatus status = goStop(RandomNumber.generate());
            cars.get(i).move(status);
        }
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();
        List<Car> winners = cars.stream().filter(o1 -> o1.getDistance() == maxDistance).collect(Collectors.toList());

        return winners;
    }

    public int getMaxDistance() {
        int maxDistance = 0;

        for (int i = 0; i < cars.size(); i++) {
            maxDistance = Math.max(maxDistance, cars.get(i).getDistance());
        }

        return maxDistance;
    }
}

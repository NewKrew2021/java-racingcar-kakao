package racing;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private List<Car> cars;
    int progressNumber = 0;

    public Racing(int progressNumber){
        this.progressNumber = progressNumber;
    }

    public void setCars(String s) {
        String[] nameArray = s.split(",");
        this.cars = new ArrayList<>();
        for (String name : nameArray) {
            this.cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Integer> repeatRacing() {
        while (checkPosition(progressNumber)) {
            this.race();
            this.racePrint();
        }
        return getPositions();
    }

    public String isWinner(int index) {
        String s = "";
        if(cars.get(index).getPosition() == this.progressNumber) {
            s += cars.get(index).getName() + ", ";
        }
        return s;
    }

    public void racePrint() {
        for (Car car : this.cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public List<Integer> getPositions() {
        List<Integer> result = new ArrayList<>();
        for (Car car : this.cars) {
            result.add(car.getPosition());
        }
        return result;
    }

    private boolean checkPosition(int numbers) {
        int maxPosition = 0;
        for (Car car : this.cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition < numbers;
    }

    private void race() {
        List<Integer> randomValues = this.makeRandomValues();
        for (int i = 0; i < this.cars.size(); i++) {
            cars.get(i).move(cars.get(i).goOrStop(randomValues.get(i)));
        }
    }

    private List<Integer> makeRandomValues() {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < this.cars.size(); i++) {
            results.add((int) (Math.random() * 10000 % 10));
        }
        return results;
    }
}

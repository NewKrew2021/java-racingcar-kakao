package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final Random random = new Random();

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

    /**
     * cars 리스트에서 index를 확인하여 해당 cars가 승자이면 승자의 이름을 콤마를 붙혀서 반환합니다.
     * 승자가 아닐경우 공백이 출력됩니다.
     * @param carIndex 확인할 cars의 index를 넣습니다.
     * @return 승자의 이름, 혹은 공백을 반환합니다.
     */
    private String getWinnerNameWithComma(int carIndex) {
        String s = "";
        if(cars.get(carIndex).getPosition() == this.progressNumber) {
            s += cars.get(carIndex).getName() + ", ";
        }
        return s;
    }

    public String returnWinnerString(){
        String s = "";
        List<Integer> resultPosition = this.getPositions();
        for (int i = 0; i < resultPosition.size(); i++) {
            s += this.getWinnerNameWithComma(i);
        }
        s = s.substring(0, s.length() - 2);
        return s + "가 최종 우승했습니다.";
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
            results.add(random.nextInt(10));
        }
        return results;
    }
}

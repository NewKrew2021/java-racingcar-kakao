package racingcar;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    public List<Car> cars;

    public void startRacing(int carCount, int round) {
        createCars(carCount);
        IntStream.range(0, round).forEach(i -> {
            racing();
            printCurrentCarPositions();
        });
    }

    private void createCars(int carCount) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void racing(){
        for (Car car : this.cars) {
            car.move(createNumber());
        }
    }

    private void printCurrentCarPositions() {
        System.out.println("AAA");
    }

    public ArrayList<Integer> getFinalCarPositions() {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < this.cars.size(); i++) {
            positions.add(this.cars.get(i).getPosition());
        }
        return positions;
    }

    public ArrayList<Integer> getWinner() {
        int maxPosition = max(getFinalCarPositions());
        return getWinnerCarsIndex(maxPosition, getFinalCarPositions());
    }

    private ArrayList<Integer> getWinnerCarsIndex(int maxPosition, List<Integer> currentCarPositions) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < currentCarPositions.size(); i++) {
            result.add(checkFarthestCarIndex(maxPosition, currentCarPositions.get(i), i));
        }
        return result.stream().filter(a -> a >= 0).collect(Collectors.toCollection(ArrayList::new));
    }

    private int checkFarthestCarIndex(int maxPosition, int currentCarPosition,int index){
        if(maxPosition == currentCarPosition){
            return index;
        }
        return -1;
    }

    private int max(List<Integer> positions) {
        int maxVal = positions.get(0);
        for (int element : positions) {
            maxVal = highValueBetween(maxVal, element);
        }
        return maxVal;
    }

    private int highValueBetween(int a, int b) {
        if (a < b) {
            return b;
        }
        return a;
    }

    private int createNumber() {
        return (int) (Math.random() * 10);
    }
}

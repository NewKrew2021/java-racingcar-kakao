package racingcar;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    private List<Car> cars;

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
        for (int i = 0; i < 3; i++) {
            positions.add(0);
        }
        return positions;
    }

    public ArrayList<Integer> getWinner(int[] currentCarPositions) {
        int farthest = max(currentCarPositions);
        return getWinnerCarsIndex(farthest, currentCarPositions);
    }

    private ArrayList<Integer> getWinnerCarsIndex(int farthest, int[] currentCarPositions) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < currentCarPositions.length; i++) {
            result.add(checkFarthestCarIndex(farthest, currentCarPositions[i], i));
        }
        return result.stream().filter(a -> a > 0).collect(Collectors.toCollection(ArrayList::new));
    }

    private int checkFarthestCarIndex(int farthest, int currentCarPosition,int index){
        if(farthest == currentCarPosition){
            return index;
        }
        return -1;
    }

    private int max(int[] arr) {
        int maxVal = arr[0];
        for (int element : arr) {
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

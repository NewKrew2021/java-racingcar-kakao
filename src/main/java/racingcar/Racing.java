package racingcar;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Racing {

    public void startRacing() {

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

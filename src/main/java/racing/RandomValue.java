package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomValue {

    static Random random = new Random();

    public static List<Integer> makeRandomValues(final int randomValuesSize, final int stopValue) {
        List<Integer> randomValues;

        do {
            randomValues = RandomValue.getRandomValueArray(randomValuesSize);
        } while(RandomValue.getRandomValueMax(randomValues) < stopValue);

        return randomValues;
    }

    private static List<Integer> getRandomValueArray(final int randomValuesSize) {
        List<Integer> randomValues = new ArrayList<>();

        for (int i = 0; i < randomValuesSize; i++) {
            randomValues.add(random.nextInt(10));
        }

        return randomValues;
    }

    private static int getRandomValueMax(final List<Integer> randomValues) {
        int maxVaule = 0;

        for( Integer randomValue : randomValues ) {
            maxVaule = Math.max( randomValue, maxVaule );
        }

        return maxVaule;
    }

}

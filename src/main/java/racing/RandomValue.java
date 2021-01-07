package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class RandomValue {

    private static final int STOP_VALUE = 3;
    static Random random = new Random();

    public static List<Boolean> makeRandomValues(final int randomValuesSize) {
        List<Boolean> randomValues;

        do {
            randomValues = makeRandomValueArray(randomValuesSize);
        } while(checkIncludeTrue(randomValues));

        return randomValues;
    }

    private static List<Boolean> makeRandomValueArray(final int randomValuesSize) {
        List<Boolean> randomValues = new ArrayList<>();

        for (int i = 0; i < randomValuesSize; i++) {
            randomValues.add( makeRandomValue() );
        }

        return randomValues;
    }

    private static boolean makeRandomValue() {
        return random.nextInt(10) > STOP_VALUE;
    }

    private static boolean checkIncludeTrue(final List<Boolean> randomValues) {
        return randomValues.stream()
                .noneMatch(b -> b);
    }

}

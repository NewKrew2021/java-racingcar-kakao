package racing;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RandomValueTest {

    @Test
    void RepeatMakeRandomValuesTest() {
        final int randomValuesSize = 3;
        final int stopValue = 4;
        final int trial = 100;

        for(int i = 0; i < trial; i++) {
            this.makeRandomValuesTest(randomValuesSize, stopValue);
        }
    }

    private void makeRandomValuesTest(final int randomValuesSize, final int stopValue) {
        int maxRandomValue = 0;
        List<Integer> randomValues =  RandomValue.makeRandomValues(randomValuesSize, stopValue);

        for( int randomValue : randomValues) {
            assertThat(randomValue).isBetween(0, 9);
            maxRandomValue = Math.max(maxRandomValue, randomValue);
        }

        assertThat(maxRandomValue).isBetween(stopValue,9);
    }

}

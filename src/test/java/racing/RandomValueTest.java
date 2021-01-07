package racing;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RandomValueTest {

    @Test
    void RepeatMakeRandomValuesTest() {
        final int randomValuesSize = 10;
        final int trial = 100;

        for(int i = 0; i < trial; i++) {
            this.makeRandomValuesTest(randomValuesSize);
        }
    }

    private void makeRandomValuesTest(final int randomValuesSize) {
        List<Boolean> randomValues =  RandomValue.makeRandomValues(randomValuesSize);

        assertThat(randomValues.size()).isEqualTo(randomValuesSize);
        assertThat(randomValues.stream()
                .filter(b->b.equals(true))
                .count()
        ).isGreaterThan(0);
    }

}

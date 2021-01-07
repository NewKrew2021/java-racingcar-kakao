package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class RacingTest {
    private Racing racing;

    @BeforeEach
    void init() {
        String carName = "coeat,dodo,dudu";
        int progressNumber = 5;
        racing = new Racing(carName, progressNumber);
    }

    @Test
    void constructorAndRaceStringTest() {
        assertThat(racing.getRaceString())
                .isEqualTo("coeat : \ndodo : \ndudu : \n");
    }

    @Test
    void decreaseAndFinishTest() {
        for (int i = 0; i < 4; i++) {
            racing.decreaseProgressNumber();
            assertThat(racing.isNotFinished())
                    .isTrue();
        }
        racing.decreaseProgressNumber();
        assertThat(racing.isNotFinished())
                .isFalse();
    }
}

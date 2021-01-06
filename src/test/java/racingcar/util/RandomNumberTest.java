package racingcar.util;

import org.junit.jupiter.api.RepeatedTest;
import racingcar.util.RandomNumber;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberTest {
    @RepeatedTest(100)
    void randomNumberGeneratorTest() {
        assertThat(RandomNumber.getRandomNumber()).isBetween(0,9);
    }
}




package racingcar;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberTest {
    @RepeatedTest(100)
    void randomNumberGeneratorTest() {
        assertThat(RandomNumber.getRandomNumber()).isBetween(0,9);
    }
}




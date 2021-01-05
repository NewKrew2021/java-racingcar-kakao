package racingcar.utils;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberGeneratorTest {
    @RepeatedTest(100)
    void randomNumberGeneratorTest() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        assertThat(randomNumberGenerator.getRandomNumber()).isBetween(0,9);
    }
}




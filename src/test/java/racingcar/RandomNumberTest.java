package racingcar;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberTest {
    @RepeatedTest(100)
    void randomNumberGeneratorTest() {
        RandomNumber randomNumber = new RandomNumber();
        assertThat(randomNumber.getRandomNumber()).isBetween(0,9);
    }
}




package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    @Test
    void randomNumber() {
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        assertThat(randomMovingStrategy.getRandomNumber()).isBetween(0, 9);
    }
}

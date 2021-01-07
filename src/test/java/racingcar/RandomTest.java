package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    @Test
    @DisplayName("랜덤 테스트: 올바른 랜덤 값을 생성하는지 테스트")
    void randomNumber() {
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        assertThat(randomMovingStrategy.getRandomNumber()).isBetween(0, 9);
    }
}

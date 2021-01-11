package carRace.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStrategyTest {
    private final int NUM_OF_TEST = 100;

    @Test
    @DisplayName("랜덤 번호를 발생시킨다.")
    public void getRandomNumber() {
        RandomStrategy randomStrategy = new RandomStrategy();
        for (int i = 0; i < NUM_OF_TEST; i++) {
            assertThat(randomStrategy.getRandomNumber()).isBetween(0, 9);
        }
    }
}

package carRace;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RandomStrategyTest {
    private final int NUM_OF_TEST = 100;

    @Test
    public void getRandomNumber() {
        RandomStrategy randomStrategy = new RandomStrategy();
        for (int i = 0; i < NUM_OF_TEST; i++) {
            assertThat(randomStrategy.getRandomNumber()).isBetween(0, 9);
        }
    }
}
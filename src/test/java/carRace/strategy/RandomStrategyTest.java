package carRace.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStrategyTest {
    private final int NUM_OF_TEST = 100;

    @Test
    @DisplayName("랜덤 번호를 발생시킨다.")
    public void getRandomNumberTest() {
        RandomStrategy randomStrategy = new RandomStrategy();
        for (int i = 0; i < NUM_OF_TEST; i++) {
            assertThat(randomStrategy.getRandomNumber()).isBetween(0, 9);
        }
    }

    @Test
    @DisplayName("랜덤넘버가 4면 true를 반환한다.")
    public void movable_move() {
        MovingStrategy movingStrategy = new RandomStrategyForMoveTest();
        assertThat(movingStrategy.movable()).isTrue();
    }

    @Test
    @DisplayName("랜덤넘버가 3이면 false를 반환한다.")
    public void movable_notMove() {
        MovingStrategy movingStrategy = new RandomStrategyForNotMoveTest();
        assertThat(movingStrategy.movable()).isFalse();
    }
}

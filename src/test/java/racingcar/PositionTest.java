package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    public void create() {
        assertThat(new Position()).isEqualTo(new Position());
    }

    @Test
    public void moveForward() {
        Position position = new Position();
        position.goForward();
        assertThat(position.getPosition()).isEqualTo(2);
    }
}

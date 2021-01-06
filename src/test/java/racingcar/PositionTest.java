package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PositionTest {

    @Test
    void create() {

        assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    @Test
    void valid() {
        assertThatThrownBy(() -> {
            int position = -1;
            new Position(position);
        });
    }

    @Test
    void moveTest() {
        Position position = new Position(1);
        position = position.move();
        assertThat(position).isEqualTo(new Position(2));
    }
}

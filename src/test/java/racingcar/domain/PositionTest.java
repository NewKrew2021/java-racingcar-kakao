package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidPositionValueException;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    public void create() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    @Test
    public void validatePosition() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(InvalidPositionValueException.class);
    }

    @Test
    public void moveForward() {
        Position position = new Position(1);
        position.goForward();
        assertThat(position.getPosition()).isEqualTo(2);
    }

    @Test
    public void getPositionValue() {
        Position position = new Position(4);
        assertThat(position.getPosition()).isEqualTo(4);
    }
}

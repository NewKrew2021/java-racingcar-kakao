package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {
    @Test
    void move() {
        Position source = new Position(1);
        Position target = source.move();

        assertThat(target).isEqualTo(new Position(2));
    }

    @Test
    void invalid() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }
}

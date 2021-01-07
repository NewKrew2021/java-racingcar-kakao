package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Position;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PositionTest {

    @Test
    public void create() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    @Test
    public void validatePosition() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
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

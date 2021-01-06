package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position();
    }

    @Test
    void createTest() {
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    @Test
    void negativePositionTest() {
        assertThatThrownBy(()->{
            new Position(-1);
        }).isInstanceOf(InvalidPositionException.class);
    }

    @Test
    void movePositionTest() {
        Position position = new Position();
        position.nextStep();
        assertThat(position).isEqualTo(new Position(1));
    }

}

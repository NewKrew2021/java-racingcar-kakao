package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {
    private Position position;

    @BeforeEach
    void init() {
        this.position = new Position();
    }

    @Test
    void constructorTest() {
        assertThat(position.getPosition())
                .isEqualTo(0);
    }

    @Test
    void increaseTest() {
        position.increase();
        assertThat(position.getPosition())
                .isEqualTo(1);
        position.increase();
        assertThat(position.getPosition())
                .isEqualTo(2);
    }

    @Test
    void toStringTest(){
        position.increase();
        assertThat(position.toString())
                .isEqualTo("-");
        position.increase();
        assertThat(position.toString())
                .isEqualTo("--");
    }
}

package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PositionTest {

    @Test
    void positionTest(){
        assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    @Test
    void moveTest(){
        Position p = new Position(1);
        p.move();
        assertThat(p).isEqualTo(new Position(2));
    }
}

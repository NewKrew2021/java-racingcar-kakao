package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    public void carPositionTest(){
        assertThat(new CarPosition(0)).isEqualTo(new CarPosition());
    }

    @Test
    public void invalidPositionTest(){
        assertThatThrownBy(()->{
            new CarPosition(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void carMoveForwardTest(){
        CarPosition position = new CarPosition();
        position.forward();
        assertThat(position).isEqualTo(new CarPosition(1));
    }
}

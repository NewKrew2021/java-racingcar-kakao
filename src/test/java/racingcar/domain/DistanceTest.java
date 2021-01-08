package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DistanceTest {

    @Test
    public void createTestWithoutArgument() {
        Distance distance = new Distance();
        assertThat(distance).isEqualTo(new Distance(0));
    }

    @Test
    public void createTest() {
        Distance distance = new Distance(3);
        assertThat(distance).isEqualTo(new Distance(3));
    }

    @Test
    public void illegalArgumentCreate() {
        assertThatThrownBy(() -> new Distance(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void moveTest() {
        Distance distance = new Distance(3);
        distance.move();
        assertThat(distance).isEqualTo(new Distance(4));
    }

    @Test
    public void largerDistanceTest() {
        Distance distance = new Distance(3);
        assertThat(distance.getLargerDistance(4)).isEqualTo(4);
        assertThat(distance.getLargerDistance(2)).isEqualTo(3);
    }

    @Test
    public void sameDistanceTest() {
        Distance distance = new Distance(4);
        assertThat(distance.isSameDistance(4)).isTrue();
        assertThat(distance.isSameDistance(3)).isFalse();
    }

}

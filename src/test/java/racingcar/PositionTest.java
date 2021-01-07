package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PositionTest {

    @DisplayName("위치가 주어졌을 때 포지션을 생성한다.")
    @Test
    void create() {

        assertThat(new Position(1)).isEqualTo(new Position(1));
    }

    @DisplayName("음의 위치가 주어지면 오류를 반환한다.")
    @Test
    void valid() {
        assertThatThrownBy(() -> {
            int position = -1;
            new Position(position);
        });
    }

    @DisplayName("위치가 주어졌을 때 move 매서드를 통해 똑바로 움직였는지 확인한다.")
    @Test
    void moveTest() {
        Position position = new Position(1);
        position = position.move();
        assertThat(position).isEqualTo(new Position(2));
    }
}

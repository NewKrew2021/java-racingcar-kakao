package racegame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    @DisplayName("Position 객체 생성 테스트")
    public void createPositionTest() {
        Position position = new Position();
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Position 객체 위치 비교 테스트")
    public void positionCompareTest() {
        Position position1 = new Position(1);
        Position position2 = new Position(5);
        assertThat(position1.compareTo(position2)).isEqualTo(1);
    }

    @Test
    @DisplayName("Position 객체 toString 테스트")
    public void positionToStringTest() {
        Position position = new Position(5);
        assertThat(position.toString()).isEqualTo("-----");
    }

}

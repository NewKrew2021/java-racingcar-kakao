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
    @DisplayName("Position 객체 이동 테스트 1")
    public void positionMoveTest() {
        Position position = new Position();
        assertThat(position.move(9)).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("Position 객체 이동 테스트 2")
    public void positionMoveTest2() {
        Position position = new Position(3);
        assertThat(position.move(4)).isEqualTo(new Position(3));
    }

    @Test
    @DisplayName("Position 객체 이동 테스트 3")
    public void positionMoveTest3() {
        Position position = new Position(1);
        assertThat(position.move(0)).isEqualTo(new Position(1));
        assertThat(position.move(5)).isEqualTo(new Position(2));
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

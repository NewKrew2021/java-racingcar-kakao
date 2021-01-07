package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarPosition;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {

    @Test
    @DisplayName("CarPosition 인스턴스를 생성하는 테스트")
    void createTest() {
        CarPosition carPosition = new CarPosition(0);
        assertThat(carPosition).isEqualTo(new CarPosition(0));
    }

    @Test
    @DisplayName("move 메서드로 이동하는지 확인하는 테스트")
    void nameLengthTest() {
        CarPosition carPosition = new CarPosition(0);
        carPosition.move(() -> true);
        carPosition.move(() -> true);
        assertThat(carPosition.isMatched(2)).isTrue();
    }
}

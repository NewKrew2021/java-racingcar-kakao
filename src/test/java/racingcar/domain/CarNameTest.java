package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;


public class CarNameTest {

    @Test
    @DisplayName("자동차 이름을 생성하는 테스트입니다.")
    void createTest() {
        CarName carName = new CarName("abcd");
        assertThat(carName).isEqualTo(new CarName("abcd"));
    }

    @Test
    @DisplayName("자동차 이름의 길이 유효성을 확인하는 테스트")
    void nameLengthTest() {
        Assertions.assertThatThrownBy(() -> {
            CarName carName = new CarName("abcdef");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름의 공백 유효성을 확인하는 테스트")
    void nameEmptyTest() {
        Assertions.assertThatThrownBy(() -> {
            CarName carName = new CarName("");
        }).isInstanceOf(IllegalArgumentException.class);
    }


}

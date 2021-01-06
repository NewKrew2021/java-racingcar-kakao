package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarNameTest {

    @Test
    @DisplayName("자동차 이름을 생성하는 테스트입니다.")
    void createTest(){
        CarName carName = new CarName("abcd");
        assertThat(carName).isEqualTo(new CarName("abcd"));
    }

    @Test
    @DisplayName("자동차 이름의 유효성을 확인하는 테스트")
    void nameLengthTest(){
        Assertions.assertThatThrownBy(() -> {
            CarName carName = new CarName("abcdef");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}

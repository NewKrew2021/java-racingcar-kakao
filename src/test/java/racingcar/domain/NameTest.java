package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {

    @Test
    void nameTest(){
        Name source = new Name("pobi");
        assertThat(source).isEqualTo(new Name("pobi"));
    }

    @Test
    @DisplayName("길이 예외 테스트")
    void lengthExceptionTest(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {new Name("dinobin");
                }).withMessageMatching("이름은 5자를 넘기면 안됩니다.");


    }

    @Test
    @DisplayName("공백 예외 테스트")
    void blankExceptionTest(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {new Name("");
                }).withMessageMatching("이름을 입력해 주세요");
    }
}

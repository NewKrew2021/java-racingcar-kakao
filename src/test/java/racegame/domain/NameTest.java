package racegame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("이름 객체 생성 테스트 1 - 정상 케이스")
    public void nameCreateTest() {
        Name name = new Name("pobi");
        assertThat(name.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("이름 객체 생성 테스트 2 - 이름이 너무 긴 경우 예외발생")
    public void nameCreateTest2() {
        assertThatThrownBy(() -> new Name("tooLongName"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

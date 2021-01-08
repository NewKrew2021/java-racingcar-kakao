package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @DisplayName("이름을 생성한다")
    @Test
    void create() {
        assertThat(new Name("hendo")).isEqualTo(new Name("hendo"));
    }

    @DisplayName("이름의 최대 글자 수가 넘어갔는지 확인한다.")
    @Test
    void valid() {
        assertThatThrownBy(() -> new Name("hendoo"));
    }

}

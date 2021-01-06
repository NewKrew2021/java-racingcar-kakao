package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class NameTest {
    @Test
    void 길이_0_이하() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name("")).withMessageMatching("이름의 길이가 0이하입니다.");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name()).withMessageMatching("이름의 길이가 0이하입니다.");
    }

    @Test
    void 길이_5_초과() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name("asdfas")).withMessageMatching("이름의 길이가 5를 초과했습니다.");
    }
}

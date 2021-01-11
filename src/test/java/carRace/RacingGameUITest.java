package carRace;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class RacingGameUITest {

    @Test
    @DisplayName("차 이름이 적합한지 검증한다.")
    public void validate_ok() {
        assertThatNoException().isThrownBy(() -> {
            RacingGameUI.validationForEach("abcde");
        });
    }

    @Test
    @DisplayName("차 이름이 공백이면 예외 발생")
    public void validate_blank() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            RacingGameUI.validationForEach("");
        });
    }

    @Test
    @DisplayName("차 이름이 5글자를 초과하면 예외 발생")
    public void validate_over5length() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            RacingGameUI.validationForEach("abcdef");
        });
    }

    @Test
    @DisplayName("차 이름이 영어가 아니면 예외 발생")
    public void validate_notAlpha() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            RacingGameUI.validationForEach("a1");
        });
    }
}

package carRace;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class RacingGameUITest {

    @Test
    public void validate_ok() {
        assertThatNoException().isThrownBy(() -> {
            RacingGameUI.validationForEach("abcde");
        });
    }

    @Test
    public void validate_blank() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            RacingGameUI.validationForEach("");
        });
    }

    @Test
    public void validate_over5length() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            RacingGameUI.validationForEach("abcdef");
        });
    }

    @Test
    public void validate_notAlpha() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            RacingGameUI.validationForEach("a1");
        });
    }
}

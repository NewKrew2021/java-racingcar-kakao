package carRace;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class NameTest {

    @Test
    @DisplayName("이름을 생성한다.")
    public void create() {
        assertThatNoException().isThrownBy(() -> {
            new Name("abcde");
        });
    }

    @Test
    @DisplayName("이름이 공백이면 예외 발생")
    public void validate_blank() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            new Name("");
        });
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 예외 발생")
    public void validate_over5length() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            new Name("abcdef");
        });
    }

    @Test
    @DisplayName("이름이 영어가 아니면 예외 발생")
    public void validate_notAlpha() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            new Name("a1");
        });
    }
}

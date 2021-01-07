package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.exception.InvalidCarNameException;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @Test
    @DisplayName("이름 유효성 테스트: 유효한 이름을 제대로 판별하는지 테스트")
    void name() {
        Throwable validCase = catchThrowable(() -> new Cars("A,B,C"));
        assertThat(validCase).doesNotThrowAnyException();

        Throwable invalidCase1 = catchThrowable(() -> new Cars("123456,12345,1234"));
        assertThat(invalidCase1).isInstanceOf(InvalidCarNameException.class);

        Throwable invalidCase2 = catchThrowable(() -> new Cars("ONE,,THREE"));
        assertThat(invalidCase2).isInstanceOf(InvalidCarNameException.class);
    }
}

package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.exception.InvalidCarNameException;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @Test
    void name() {
        Throwable validCase = catchThrowable(() -> new Cars("A,B,C"));
        assertThat(validCase).doesNotThrowAnyException();

        Throwable invalidCase1 = catchThrowable(() -> new Cars("123456,12345,1234"));
        assertThat(invalidCase1).isInstanceOf(InvalidCarNameException.class);

        Throwable invalidCase2 = catchThrowable(() -> new Cars("ONE,,THREE"));
        assertThat(invalidCase2).isInstanceOf(InvalidCarNameException.class);
    }
}

package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.TryNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class TryNumberTest {

    @Test
    public void tryNumberTest1(){
        TryNumber tryNumber = new TryNumber(1);
        assertThat(tryNumber.isLeftTryNumber()).isTrue();
    }

    @Test
    public void tryNumberTest2(){
        TryNumber tryNumber = new TryNumber(1);
        tryNumber.useTryNumber();
        assertThat(tryNumber.isLeftTryNumber()).isFalse();
    }
}

package racingcar.utils;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @Test
    public void randomNumberTest(){
        assertThat(
                RandomNumberForRacing
                        .getRandomNumberForRacing())
                .isBetween(0,9);
    }
}

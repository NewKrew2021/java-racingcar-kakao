package racingcar.utils;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.type;

public class RandomNumberTest {

    @Test
    public void randomNumberTest(){
        assertThat(
                RandomNumberForRacing
                        .getRandomNumberForRacing())
                .isBetween(0,9);
    }

    @Test
    public void sixRandomNumberTest(){
        assertThat(RandomNumberForRacing.getRandomNumberListForRacing(6).size())
                .isEqualTo(6);
    }
}

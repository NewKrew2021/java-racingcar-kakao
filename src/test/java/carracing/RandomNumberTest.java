package carracing;

import carracing.domain.RandomNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @Test
    void rangeTest(){
        assertThat(RandomNumber.getRandomNumber(5)).isLessThan(5);
    }
}

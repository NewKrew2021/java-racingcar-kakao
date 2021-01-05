package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    private RandomNumber randomNum;

    @BeforeEach
    void setting() {
        randomNum = new RandomNumber();
    }

    @Test
    void randomNumber() {
        assertThat(randomNum.generate()).isBetween(0, 9);
    }

    @Test
    void directionCheck(){
        assertThat(randomNum.direction()).isInstanceOfAny(CarStatus.class);
    }
}

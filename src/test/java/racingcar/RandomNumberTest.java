package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @Test
    public void randomNumberTest(){
        RandomNumber r = new RandomNumber(4);
        assertThat(r).isEqualTo(new RandomNumber(4));
    }

    @Test
    public void isMovalbleTest(){
        RandomNumber r1 = new RandomNumber(4);
        assertThat(r1.isMovableRandomNumber()).isTrue();

        RandomNumber r2 = new RandomNumber(3);
        assertThat(r2.isMovableRandomNumber()).isFalse();
    }

}

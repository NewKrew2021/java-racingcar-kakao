package RacingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {
    private RacingCar racingCar;
    private Racing racing;

    @BeforeEach
    public void setUp() {
        racingCar = new RacingCar();
        racing = new Racing();
    }

    @Test
    public void nameLengthCheck() {
        racingCar.setName("aaaaa");
        assertThat(racingCar.isNameLengthValid()).isTrue();
        racingCar.setName("aaaaaa");
        assertThat(racingCar.isNameLengthValid()).isFalse();
    }

    @Test
    public void nameSplitCheck() {
        assertThat(racing.splitNames("aaa,bbb,ccc")).containsExactly(new String[] {"aaa", "bbb", "ccc"});
    }

}

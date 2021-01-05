package RacingCar;

import RacingCar.Model.RacingCar;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

public class RacingCarTest {
    private RacingCar racingCar;
    private Racing racing;

    @Test
    public void validNameLengthCheck() {
        racingCar = new RacingCar("aaaaa");
        assertThat(racingCar.isNameLengthValid()).isTrue();
    }

    @Test
    public void invalidNameLengthCheck() {
        racingCar = new RacingCar("aaaaaa");
        assertThat(racingCar.isNameLengthValid()).isFalse();
    }


    @Test
    public void nameSplitCheck() {
        racing = new Racing("");
        assertThat(racing.splitNames("aaa,bbb,ccc")).containsExactly(new String[] {"aaa", "bbb", "ccc"});
    }

    @Test
    public void setRacingCarNameCheck() {
        racing = new Racing("aaa,bbb,ccc");
        assertThat(racing.getRacingCars()).extracting(RacingCar::getName).containsExactly("aaa", "bbb", "ccc");
    }

}

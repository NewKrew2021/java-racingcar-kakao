package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    public void carNameTest(){
        CarName carName = new CarName("mac");
        assertThat(carName).isEqualTo(new CarName("mac"));
    }

    @Test
    public void invalidCarNameTest(){
        assertThatThrownBy(()->{
            new CarName("123456");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->{
            new CarName("");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->{
            new CarName(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}

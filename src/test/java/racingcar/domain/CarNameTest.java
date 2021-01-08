package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    public void invalidCarNameTest(){
        assertThatThrownBy(() ->
            new CarName("123456")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->
            new CarName("")
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->
            new CarName(null)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}

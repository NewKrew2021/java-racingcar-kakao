package domain;

import exception.InvalidCarNameException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {
    @Test
    void validConstructorTest() {
        CarName name = new CarName("abcde");
        assertThat(name.toString()).isEqualTo("abcde");
    }

    @Test
    void invalidConstructorTest() {
        assertThatThrownBy(()->{
            CarName name = new CarName("abcdef");
        }).isInstanceOf(InvalidCarNameException.class)
        .hasMessageContaining("잘못된 자동차 이름입니다");
    }
}

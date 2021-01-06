package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {

    @Test
    void nameTest(){
        Name source = new Name("pobi");
        assertThat(source).isEqualTo(new Name("pobi"));
    }

    @Test
    @DisplayName("예외 테스트")
    void exceptionTest(){
        assertThatThrownBy(()->{
            assertThat(new Name("dinobin"));
            assertThat(new Name(""));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

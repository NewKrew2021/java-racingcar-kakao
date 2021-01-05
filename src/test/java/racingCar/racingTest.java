package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class racingTest {

    private Parser parser;
    @BeforeEach
    public void setUp(){
        parser=new Parser();
    }
    /*
    1. 자동차 이름 문자열은 ,로 구분된다.
    , 앞뒤의 공백은 자동으로 지워준다.
    * */
    @Test
    public void carNameTest() {
        String userInput = "pobi,crong,honux, teo ";
        List<String>  result = parser.parsing(userInput);
        Assertions.assertThat(result)
                    .containsAll(Arrays.asList("pobi", "crong", "honux", "teo"));
    }

    @Test
    public void longNameExceptionTest() {
        String userInput = "bmoadv,pobi,vavaa";
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> parser.parsing(userInput));
    }
}

package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    public void splitNameTest(){
        Racing rc = new Racing();
        assertThat(rc.splitNames("1,2,3")).isEqualTo(Arrays.asList("1","2","3"));
    }
}

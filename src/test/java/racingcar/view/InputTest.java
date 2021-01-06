package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.view.Input;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputTest {
    @Test
    void carNameSplitTest() {
        assertThat(Input.getSplitName("jack,jayk")).asList().containsAll(Arrays.asList("jack","jayk"));
    }

}
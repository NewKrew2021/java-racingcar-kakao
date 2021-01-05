package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputTest {
    @Test
    void carNameSplitTest() {
        Input input = new Input();
        input.setInput("jack,jayk");
        assertThat(input.getSplitName()).asList().containsAll(Arrays.asList("jack","jayk"));
    }
}
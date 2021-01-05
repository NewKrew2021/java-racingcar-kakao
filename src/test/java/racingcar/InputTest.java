package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputTest {
    Input input;

    @BeforeEach
    void beforeEach() {
        input = new Input();
    }

    @Test
    void carNameSplitTest() {
        input.setInput("jack,jayk");
        assertThat(input.getSplitName()).asList().containsAll(Arrays.asList("jack","jayk"));
    }

}
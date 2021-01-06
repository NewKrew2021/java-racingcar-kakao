package racingcar.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputTest {
    @Test
    void carNameSplitTest() {
        assertThat(Input.splitName("jack,jayk"))
                .asList()
                .containsAll(Arrays.asList("jack","jayk"));
    }
}
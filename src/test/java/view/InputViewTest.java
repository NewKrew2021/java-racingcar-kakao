package view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    @Test
    public void parseNamesTest() throws Exception {
        String text = "pobi,crong,honux";
        assertThat(InputView.parseNames(text)).isEqualTo(new String[]{"pobi", "crong", "honux"});
    }

    @Test
    public void lenNameTest() {
        String text = "alice,bob,charlie";
        assertThatThrownBy(() -> InputView.parseNames(text))
                .isInstanceOf(LengthOfNameException.class);
    }

    @Test
    public void numNamesTest() {
        String text = "alice";
        assertThatThrownBy(() -> InputView.parseNames(text))
                .isInstanceOf(NumberOfNamesException.class);
    }
}
package view;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputViewTest {
    @Test
    public void parseNamesTest() throws Exception {
        String text = "pobi,crong,honux";
        assertThat(InputView.parseNames(text), is(new String[]{"pobi", "crong", "honux"}));
    }

    @Test(expected = LengthOfNameException.class)
    public void lenNameTest() throws Exception {
        String text = "alice,bob,charlie";
        InputView.parseNames(text);
    }

    @Test(expected = NumberOfNamesException.class)
    public void numNamesTest() throws Exception {
        String text = "alice";
        InputView.parseNames(text);
    }
}
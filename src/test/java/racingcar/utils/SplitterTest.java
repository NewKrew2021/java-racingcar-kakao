package racingcar.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SplitterTest {

    @Test
    public void splitString() {
        String names = "you,and,me";
        assertThat(Splitter.splitNames(names)).containsExactly("you", "and", "me");
    }

    @Test
    public void splitStringIncludeSpace() {
        String names = "mac, book,pro";
        assertThat(Splitter.splitNames(names)).containsExactly("mac", "book", "pro");
    }
}

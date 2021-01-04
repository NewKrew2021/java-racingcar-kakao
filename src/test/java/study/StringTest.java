package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split(){
        String[] test = "1,2".split(",");
        assertThat(test).containsExactly("1", "2");
    }
}

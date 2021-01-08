package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomRandomTest {

    @Test
    void isValidRange() {
        int num = CustomRandom.nextInt();
        assertThat(0 <= num && num <= 9).isTrue();
    }
}

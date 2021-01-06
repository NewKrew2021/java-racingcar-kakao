package Utils;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilTest {
    private static final int BOUND = 10;

    @RepeatedTest(100)
    void generateRandomNumber() {
        int randomNumber = NumberUtil.generateRandomNumber(BOUND);
        assertThat(randomNumber).isBetween(0, 9);
    }
}

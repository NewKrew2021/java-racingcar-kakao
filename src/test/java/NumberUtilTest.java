import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilTest {

    @RepeatedTest(100)
    void 난수생성() {
        int randomNumber = NumberUtil.createRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }
}

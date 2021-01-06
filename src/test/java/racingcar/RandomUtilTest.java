package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomUtilTest {

    @Test
    public void testRandomValueRange() {

        RandomUtil randomUtil = new RandomUtil();
        assertTrue(randomUtil.getRandomValue() >= 0 && randomUtil.getRandomValue() < 10);
    }
}

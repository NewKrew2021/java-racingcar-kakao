package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMovingStrategyTest {

    private final RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();

    @Test
    @DisplayName("난수값이 0과 9 사이에 있는지 확인한다.")
    void makeRandomNumberTest() {
        assertThat(randomMovingStrategy.makeRandomNumber()).isGreaterThan(-1).isLessThan(10);
    }

    @Test
    @DisplayName("난수값이 3이하인 경우에는 기준을 넘지 않고, 4이상이면 기준을 넘는지 확인한다.")
    void exceedMovingCriterionTest() {
        int stopRandomNumber = 3;
        int goRandomNumber = 4;
        assertThat(randomMovingStrategy.exceedMovingCriterion(stopRandomNumber)).isFalse();
        assertThat(randomMovingStrategy.exceedMovingCriterion(goRandomNumber)).isTrue();
    }
}

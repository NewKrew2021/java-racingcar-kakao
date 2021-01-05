package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    private static Racing racing;

    @BeforeAll
    static void setUp() {
        racing = new Racing();
        racing.setCarList("pobi,crong,honux");
    }

    @Test
    void getName() {
        List<String> nameList = Arrays.asList("pobi", "crong", "honux");

        for (int i = 0; i < nameList.size(); i++) {
            assertThat(racing.getCarList().get(i).getName()).isEqualTo(nameList.get(i));
        }
    }

    @Test
    void carNameCheck() {
        assertThat(racing.getMaxLength()).isLessThan(6);
    }

    @Test
    void randomNumber() {
        assertThat(RandomNumber.generate()).isBetween(0, 10);
    }

    @Test
    void go() {
        assertThat(racing.goStop(4)).isEqualTo(CarStatus.Go);
    }

    @Test
    void stop() {
        assertThat(racing.goStop(3)).isEqualTo(CarStatus.Stop);
    }
}

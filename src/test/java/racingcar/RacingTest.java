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
    void setName() {
        List<String> nameList = Arrays.asList("pobi", "crong", "honux");

        for (int i = 0; i < nameList.size(); i++) {
            assertThat(racing.getCarList().get(i).getName()).isEqualTo(nameList.get(i));
        }
    }

    @Test
    void nameLengthCheck() {
        Racing case1 = new Racing();
        case1.setCarList("12345,1234,123");
        assertThat(case1.isTooLong()).isFalse();

        Racing case2 = new Racing();
        case2.setCarList("123456,12345,1234");
        assertThat(case2.isTooLong()).isTrue();
    }

    @Test
    void randomNumber() {
        assertThat(RandomNumber.generate()).isBetween(0, 9);
    }

    @Test
    void go() {
        assertThat(racing.goStop(4)).isEqualTo(CarStatus.Go);
    }

    @Test
    void stop() {
        assertThat(racing.goStop(3)).isEqualTo(CarStatus.Stop);
    }

    @Test
    void move() {
        Car car = new Car("test", 0);
        car.move(CarStatus.Stop);
        assertThat(car.getDistance()).isEqualTo(0);

        car.move(CarStatus.Go);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void winner() {
        racing.getCarList().get(0).move(CarStatus.Go);
        assertThat(racing.getWinner()).hasSize(1).contains(racing.getCarList().get(0));

        racing.getCarList().get(2).move(CarStatus.Go);
        assertThat(racing.getWinner()).hasSize(2).doesNotContain(racing.getCarList().get(1));
    }
}

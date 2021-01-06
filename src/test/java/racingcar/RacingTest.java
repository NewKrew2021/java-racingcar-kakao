package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class RacingTest {
    private static Racing racing;

    @BeforeAll
    static void setUp() {
        racing = new Racing("pobi,crong,honux");
    }

    @Test
    void setName() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");

        for (int i = 0; i < names.size(); i++) {
            assertThat(racing.getCars().get(i).getName()).isEqualTo(names.get(i));
        }
    }

    @Test
    void nameLengthCheck() {
        Throwable validCase = catchThrowable(() -> new Racing("12345,1234,123"));
        assertThat(validCase).doesNotThrowAnyException();

        Throwable invalidCase = catchThrowable(() -> new Racing("123456,12345,1234"));
        assertThat(invalidCase).isInstanceOf(InvalidCarNameException.class);
    }

    @Test
    void randomNumber() {
        RandomGenerator randomGenerator = new RandomGenerator();
        assertThat(randomGenerator.generate(10)).allMatch(o1 -> o1 >= 0 && o1 < 10);
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
        racing.moveAll(Arrays.asList(4, 3, 3));
        assertThat(racing.getWinners()).hasSize(1).contains(racing.getCars().get(0));

        racing.moveAll(Arrays.asList(3, 3, 4));
        assertThat(racing.getWinners()).hasSize(2).doesNotContain(racing.getCars().get(1));
    }
}

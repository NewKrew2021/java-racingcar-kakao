package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.List;

public class CarsTest {

    @Test
    public void testSinglewinner() {

        Cars cars = new Cars(Arrays.asList(new Car("pobi", 1), new Car("crong", 1), new Car("honux", 1), new Car("teo", 3)));
        List<String> winners = Arrays.asList(new String("teo"));

        List<String> rank = cars.getWinners();
        for (int i = 0; i < winners.size(); i++) {
            Assertions.assertThat(winners.get(i).equals(rank.get(i))).isEqualTo(true);
        }

    }

    @Test
    public void testMultiWinner() {

        Cars cars = new Cars(Arrays.asList(new Car("pobi", 3), new Car("crong", 1), new Car("honux", 1), new Car("teo", 3)));
        List<String> winners = Arrays.asList(new String("pobi"), new String("teo"));

        List<String> rank = cars.getWinners();
        for (int i = 0; i < winners.size(); i++) {
            Assertions.assertThat(winners.get(i).equals(rank.get(i))).isEqualTo(true);
        }
    }


}

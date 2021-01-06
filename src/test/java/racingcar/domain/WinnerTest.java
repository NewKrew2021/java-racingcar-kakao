package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    @Test
    void findWinner() {
        Winners winners = new Winners(
                new ArrayList<>(Arrays.asList(
                    new Car("huey", 3),
                    new Car("pobi", 3)
                )));

        winners.addWinner(3,new Car("add",3));

        assertThat(winners).isEqualTo(new Winners(
                Arrays.asList(
                        new Car("huey", 3),
                        new Car("pobi", 3),
                        new Car("add",3)
                )));
    }

    @Test
    void create() {
        Winners winners = new Winners(
                Arrays.asList(
                        new Car("huey"),
                        new Car("pavlo")
                ));

        assertThat(winners).isEqualTo(new Winners(
                Arrays.asList(
                        new Car("huey"),
                        new Car("pavlo")
                )));
    }
}

package racegame.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WinnersTest {

    @Test
    public void winnersCreateTest() {
        Car pobi = new Car("pobi", 5);
        Car teo = new Car("teo", 8);
        Car tarkov = new Car("tarko", 8);
        Cars cars = new Cars(Arrays.asList(pobi, teo, tarkov));
        Winners winners = cars.getWinners();
        assertThat(winners.toString()).isEqualTo("teo, tarko");
    }

}

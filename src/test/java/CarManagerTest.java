import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

public class CarManagerTest {
    @Test
    void cars() {
        CarManager carManager = new CarManager();
        carManager.createCar("pobi");
        carManager.createCar("honux");
        carManager.createCar("crong");

        assertThat(carManager.getCars())
                .extracting(Car::getName)
                .isEqualTo(Arrays.asList("pobi", "honux", "crong"));
    }

    @Test
    void name() {

    }
}
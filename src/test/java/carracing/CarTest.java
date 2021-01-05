package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp(){
        car = new Car("car1");
    }

    @Test
    void generateCar(){
        assertThat(car.getCarInfoString()).isEqualTo("car1 : ");
    }

    @Test
    void goTest(){
        car.go();
        car.go();
        assertThat(car.getCarInfoString()).isEqualTo("car1 : --");
    }
}

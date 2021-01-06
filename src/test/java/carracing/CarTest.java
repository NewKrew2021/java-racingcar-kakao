package carracing;

import carracing.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp(){
        car = new Car("car1", 2);
    }

    @Test
    void generateCar(){
        assertThat(car.getName()).isEqualTo("car1");
    }

    @Test
    void positionTest(){
        assertThat(car.getPosition()).isEqualTo(2);
    }
}

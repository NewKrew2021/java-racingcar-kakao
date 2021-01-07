package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Car car;

    @BeforeEach
    public void setUp(){
        car = new Car("pobi", 3);
    }

    @Test
    public void testMove(){
        car.move(4);
        assertThat(car.getLocation()).isEqualTo(4);
        car.move(3);
        assertThat(car.getLocation()).isEqualTo(4);
    }

    @Test
    public void testGetStatus(){
        assertThat(car.getStatus()).isEqualTo("pobi : ---");
    }

}

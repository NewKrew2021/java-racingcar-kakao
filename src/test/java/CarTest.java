import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    public void go() {
        Car car = new Car("jack");
        car.go();
        car.go();
        car.go();
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    public void run() {
        Car car = new Car("jack");
        car.run(3);
        assertThat(car.getPosition()).isEqualTo(0);

        car.run(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}

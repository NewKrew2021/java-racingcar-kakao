import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    public void isNameValid() {
        assertThat(new Car("snoopy").isValid()).isFalse();
        assertThat(new Car("yuni").isValid()).isTrue();
    }

    @Test
    public void go() {
        Car car = new Car("jack");
        car.go();
        car.go();
        car.go();
        assertThat(car.getPosition()).isEqualTo(3);
    }
}

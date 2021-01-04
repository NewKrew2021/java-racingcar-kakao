import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void length0orNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(""));
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(null));
    }

    @Test
    void length5이하() {
        Car car2 = new Car("12345");
        assertThat(car2.getName()).isEqualTo("12345");
    }

    @Test
    void length6이상() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("123456"));
    }
}

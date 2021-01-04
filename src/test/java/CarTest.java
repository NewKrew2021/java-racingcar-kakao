import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    public void isNameValid() {
        assertThat(new Car("snoopy").isValid()).isFalse();
        assertThat(new Car("yuni").isValid()).isTrue();
    }
}

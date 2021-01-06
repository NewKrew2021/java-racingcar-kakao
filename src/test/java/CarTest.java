import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Car car;

    @Before
    public void setUp() {
        car = new Car("jack");
    }

    @DisplayName("4 이상이면 이동한다")
    @Test
    public void run() {
        car.runWithCondition(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("3 이하면 이동하지 않는다")
    @Test
    public void dontRun() {
        car.runWithCondition(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}

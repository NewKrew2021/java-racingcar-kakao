package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("jack");
    }

    @DisplayName("4 이상이면 이동한다")
    @Test
    void run() {
        car.runWithCondition(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("3 이하면 이동하지 않는다")
    @Test
    void dontRun() {
        car.runWithCondition(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = { "jayden", "", " " })
    void invalidName(String argument) {
        assertThatThrownBy(() -> new Car(argument)).isInstanceOf(IllegalArgumentException.class);
    }
}

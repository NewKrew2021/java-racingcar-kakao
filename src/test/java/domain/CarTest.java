package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    private Engine alwaysMoveEngine;
    private Engine neverMoveEngine;

    @BeforeEach
    void setUp() {
        alwaysMoveEngine = new AlwaysMoveEngine();
        neverMoveEngine = new NeverMoveEngine();
    }

    @Test
    void createCar() {
        Car car = new Car(alwaysMoveEngine, "valid");
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.getName()).isEqualTo("valid");
    }

    @Test
    void length0orNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(alwaysMoveEngine, ""));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(alwaysMoveEngine, null));
    }

    @Test
    void longerThan6() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(alwaysMoveEngine, "sixlen"));
    }

    @Test
    void move() {
        Car car = new Car(alwaysMoveEngine, "car");
        car.tryMoving();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void dontMove() {
        Car car = new Car(neverMoveEngine, "car");
        car.tryMoving();
        assertThat(car.getPosition()).isEqualTo(0);
    }


    @Test
    void isForwardThan() {
        Car car1 = new Car(alwaysMoveEngine, "car1");
        car1.tryMoving();
        car1.tryMoving();
        Car car2 = new Car(alwaysMoveEngine, "car2");
        car2.tryMoving();

        assertThat(car1.isForwardThan(car2)).isTrue();
    }

    @Test
    void isSamePositionWith() {
        Car car1 = new Car(alwaysMoveEngine, "car1");
        Car car2 = new Car(alwaysMoveEngine, "car2");
        assertThat(car1.isSamePositionWith(car2)).isTrue();

        car1.tryMoving();
        car2.tryMoving();
        assertThat(car1.isSamePositionWith(car2)).isTrue();

        car2.tryMoving();
        assertThat(car1.isSamePositionWith(car2)).isFalse();
    }
}

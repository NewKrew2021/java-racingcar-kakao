package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    Car car;
    @BeforeEach
    void setUp() {
        car = new Car("붕붕이", 1);
    }

    @Test
    void max() {
        assertThat(car.max(3)).isEqualTo(3);
    }

    @Test
    void isWinner() {
        car = new Car("붕붕이", 2);
        assertThat(car.isWinner(2)).isTrue();
    }

    @Test
    void move() {
        car.move(new RandomNumber(4));

        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    void stop() {
        car.move(new RandomNumber(3));
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    void createCar() {
        assertThat(car.getName()).isEqualTo(new Name("붕붕이"));
    }
}
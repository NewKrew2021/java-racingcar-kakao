package com.nextstep.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    private final int ONE_UNIT = 1;

    @Test
    void shouldMoveOneUnit() {
        Car car = new Car("test", 0);
        int currentLocation = car.getLocation();

        car.move();

        assertThat(car.getLocation()).isEqualTo(currentLocation + ONE_UNIT);
    }

    @Test
    void carHasCorrectName() {
        Car car = new Car("hello", 0);

        assertThat(car.getName()).isEqualTo("hello");
    }

    @Test
    void areEqualInHashCode() {
        Car car = new Car("hi", 0);

        assertThat(car.hashCode())
                .isEqualTo(new Car("hi", 0).hashCode());
    }

    @Test
    void areNotEqualInHashCode() {
        Car car = new Car("hello", 0);

        assertThat(car.hashCode()).isNotEqualTo(new Car("hi", 0).hashCode());
    }

    @DisplayName("이름과 위치가 같은 차면 같은 객체로 취급")
    @Test
    void testEquals() {
        Car car = new Car("equal", 5);

        assertThat(car).isEqualTo(new Car("equal", 5));
    }

    @DisplayName("5글자를 초과하는 이름의 경우 Exception 발생")
    @Test
    void carCannotHandleLongName() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Car("longname", 0));
    }
}

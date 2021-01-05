package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RacingcarTest {
    private Racingcar racingcar;

    @BeforeEach
    void setting() {
        racingcar = new Racingcar();
    }

    @Test
    void getName() {
        assertThat(racingcar.getCarName("pobi,crong,honux")).isEqualTo(Arrays.asList("pobi","crong","honux"));
    }

    @Test
    void carNameCheck() {
        racingcar.getCarName("pobi, crong, honux");
        assertThat(racingcar.carNameCheck()).isEqualTo(true);
    }





}
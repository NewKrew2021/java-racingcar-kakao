package carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingProgramTest {

    private CarRacingProgram carRacingProgram;

    @BeforeEach
    void setUp() {
        carRacingProgram = new CarRacingProgram();
    }

    @Test
    @DisplayName("랜덤 값이 범위 내에 있는지 여부 테스트")
    void getRandomNumber() {
        assertThat(carRacingProgram.getRandomNumber()).isBetween(0, 9);
    }
}

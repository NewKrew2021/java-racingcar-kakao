package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingProgramTest {

    private CarRacingProgram carRacingProgram;

    @BeforeEach
    void setUp(){
        carRacingProgram = new CarRacingProgram();
    }

    @Test
    void getRandomNumberTest(){
        assertThat(carRacingProgram.getRandomNumber()).isBetween(0, 9);
    }
}

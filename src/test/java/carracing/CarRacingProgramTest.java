package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingProgramTest {

    CarRacingProgram carRacingProgram;

    @BeforeEach
    void setUp(){
        carRacingProgram = new CarRacingProgram();
    }

    @Test
    void getRandomInstanceTest(){
        assertThat(carRacingProgram.getRandomInstance()).isEqualTo(carRacingProgram.getRandomInstance());
    }

    @Test
    void getRandomNumberTest(){
        assertThat(carRacingProgram.getRandomNumber()).isBetween(0, 9);
    }
}

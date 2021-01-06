package carracing;

import carracing.domain.CarRacingProgram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingProgramTest {

    CarRacingProgram carRacingProgram;

    @BeforeEach
    void setUp(){
        carRacingProgram = new CarRacingProgram();
    }

}

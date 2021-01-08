package carracing;

import carracing.domain.Car;
import carracing.service.CarRacingProgram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingProgramTest {

    CarRacingProgram carRacingProgram;

    @BeforeEach
    void setUp(){
        carRacingProgram = new CarRacingProgram();
    }

    @Test
    void splitCarNamesNullTest(){
        assertThatThrownBy(() ->{
            carRacingProgram.splitCarNames(null);
        }).isInstanceOf(RuntimeException.class);
    }
}

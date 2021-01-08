package carracing;

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

    @Test
    void splitCarNamesLengthTest(){
        assertThatThrownBy(() ->{
            carRacingProgram.splitCarNames("car1,car2car3");
        }).isInstanceOf(RuntimeException.class);
    }
}

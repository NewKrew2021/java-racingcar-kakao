package carracing.service;

import carracing.domain.Car;
import carracing.service.CarRacingProgram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarRacingProgramTest {

    CarRacingProgram carRacingProgram;

    @BeforeEach
    void setUp(){
        carRacingProgram = new CarRacingProgram("car1,car2",3);
    }

    @Test
    void splitCarNamesNullTest(){
        assertThatThrownBy(() ->{
            carRacingProgram.splitCarNames(null);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void findWinnerTest(){
        assertThat(carRacingProgram.findRaceWinner()).asList().isNotEmpty();
    }

}

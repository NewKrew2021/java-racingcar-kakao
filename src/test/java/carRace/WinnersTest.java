package carRace;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @Test
    public void getWinnersNamesTest(){
        Winners winners = new Winners(
                Arrays.asList(
                        new Car("test5", 10),
                        new Car("test6", 10)
                )
        );

        List<String> realResult = winners.getWinnersNames();
        List<String> expectedResult = Arrays.asList(
                "test5", "test6"
        );

        assertThat(realResult).isEqualTo(expectedResult);
    }

}

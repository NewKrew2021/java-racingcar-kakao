package racingcar;

import calculator.StringCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {
    RacingGame racing;

    @BeforeEach
    void setUp(){
        racing = new RacingGame();
    }

    @Test
    public void stringToNames(){
        String input = "pobi,crong,honux";
        String[] names = RacingGame.stringToNames(input);
        assertThat(names).contains("pobi", "crong", "honux");
    }

    @Test
    public void testInputIsEmpty(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String input = "";
            String[] names = RacingGame.stringToNames(input);
        });

    }

    @Test
    public void testMakeCars(){
        String input = "pobi,crong";
        String[] names = racing.stringToNames(input);
        racing.makeCars(names);
        assertThat(racing.cars).extracting("name").contains("pobi", "crong");
    }

    @Test
    public void testCheckNameLength(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String input = "carname";
            racing.checkNameLength(input);
        });
    }

    @Test
    public void testSetcount(){
        racing.setCount(5);
        assertThat(racing.count).isEqualTo(5);
    }

    @Test
    public void testWinner(){
        Car[] cars = new Car[3];
        cars[0] = new Car("pobi", 5);
        cars[1] = new Car("crong",3);
        cars[2] = new Car("honux",5);
        racing.cars = cars;
        assertThat(racing.getWinners()).contains("pobi","honux");
    }

}

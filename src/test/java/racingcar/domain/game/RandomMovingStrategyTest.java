package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMovingStrategyTest {

    @DisplayName("1~10 사이의 랜덤 숫자가 들어왔을 때, 입력된숫자가 4이상이면 true 미만이면 false가 나오는지 확인한다. ")
    @ParameterizedTest
    @CsvSource({"1,flase", "2,false", "3,false", "10,true", "4,true"})
    public void roundFinishTest(int inputNumber, boolean expected) {
        //given
        MovingStrategy randomMovingStrategy = new RandomMovingStrategy() {
            @Override
            protected int makeRandomNumber() {
                return inputNumber;
            }
        };

        //then
        assertThat(randomMovingStrategy.moveable()).isEqualTo(expected);
    }

}

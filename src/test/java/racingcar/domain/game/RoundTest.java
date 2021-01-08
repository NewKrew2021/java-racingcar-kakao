package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RoundTest {

    @DisplayName("최종 라운드가 주어졌을 때, 라운드를 생성한다")
    @Test
    void create() {
        assertThat(new Round(10)).isEqualTo(new Round(10));
    }

    @DisplayName("최종 라운드가 주어졌을 때, 라운드를 최종라운드 만큼 진행했으면 true를 반환한다.")
    @ParameterizedTest
    @CsvSource({"10,10,true","10,9,false"})
    public void roundFinishTest(int totalRound, int playRound, boolean expected) {
        //given
        Round round = new Round(totalRound);

        //when
        for (int i = 0; i < playRound; i++) {
            round.playCurrentRound();
        }
        //then
        assertThat(round.isFinished()).isEqualTo(expected);
    }

}

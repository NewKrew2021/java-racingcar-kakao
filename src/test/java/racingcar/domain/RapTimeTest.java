package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RapTimeTest {
    private RapTime rapTime;

    @BeforeEach
    void setUp() {
        rapTime = new RapTime(5);
    }

    @ParameterizedTest
    @CsvSource({"1,false", "2,false", "4,false", "5,true"})
    void endTest(int time, boolean result) {
        for (int i = 0; i < time; i++) {
            rapTime.downTime();
        }
        assertThat(rapTime.isEnd()).isEqualTo(result);
    }

    @Test
    void ExceptionTest(){
        for (int i = 0; i < 5; i++) {
            rapTime.downTime();
        }
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(()->{
            rapTime.downTime();
        }).withMessageMatching("레이싱이 이미 종료되었습니다.");
    }
}

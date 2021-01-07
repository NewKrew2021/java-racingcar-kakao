package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

    @Test
    @DisplayName("null 값이 들어올 경우 0을 반환해야 한다.")
    void nullTest() {
        String data = null;
        int result = StringCalculator.calculate(data);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName(",와 : 를 기준으로 분리하여 값을 더해야 한다.")
    @CsvSource(value = {" !0", "3!3", "3,1!4", "1,2:3!6"}, delimiter = '!')
    void calculateTest(String data, int expected) {
        int result = StringCalculator.calculate(data);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("\\n 을 기준으로 사용자 정의 구분자를 지정할 수 있다.")
    void customSeparatorTest() {
        String data = "//;\n1;2;3";
        int result = StringCalculator.calculate(data);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 들어오면 오류가 발생해야 한다.")
    void minusNumberTest() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(()->{
            String data = "-1,2,3";
            StringCalculator.calculate(data);
        });
    }
}
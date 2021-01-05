package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void nullCheck() {
        assertThat(calculator.calculate("")).isEqualTo(0);
        assertThat(calculator.calculate(null)).isEqualTo(0);
    }

    @Test
    public void digitCheck() {
        assertThat(calculator.calculate("1")).isEqualTo(1);
    }

    @Test
    public void commaCheck() {
        assertThat(calculator.calculate("1,2")).isEqualTo(3);
    }

    @Test
    public void collonCheck() {
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    public void customDelimeterCheck() {
        assertThat(calculator.calculate("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    public void exceptionCheck() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> calculator.calculate("-1,2;3"));
    }
}

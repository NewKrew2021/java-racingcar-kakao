package calculator.domain;

import calculator.io.Input;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Test
    public void customAddTest(){
        assertThat(Calculator.add(Input.splitUserInput("//'\n1'2'3'4'5"))).isEqualTo(15);
    }

    @Test
    public void addTest() {
        assertThat(Calculator.add(Input.splitUserInput("1,2,3"))).isEqualTo(6);
    }
}

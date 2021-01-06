package calculator;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @Test
    public void test_empty(){
        assertThat(StringCalculator.sum(null)).isEqualTo(0);
        assertThat(StringCalculator.sum("")).isEqualTo(0);

    }

    @Test
    public void test_singleNo(){
        assertThat(StringCalculator.sum("1")).isEqualTo(1);
    }

    @Test
    public void splitCommaAndSum(){
        assertThat(StringCalculator.sum("1,2")).isEqualTo(3);
    }

    @Test
    public void splitCommaColonAndSum(){
        assertThat(StringCalculator.sum("1,2:3")).isEqualTo(6);
    }

    @Test
    public void splitCustomAndSum() {
        assertThat(StringCalculator.sum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    public void test_negativeNo(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.sum("-1,2,3");
        });
    }

}

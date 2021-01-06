package plusNumber;




import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class PlusNumberCalTest {

    PlusNumberCal number;

    @BeforeEach
    public void setup(){
        this.number = new PlusNumberCal();
    }

    @Test
    public void plusNumberEmpty(){
        assertThat(number.calculate("")).isEqualTo(0);
        assertThat(number.calculate(null)).isEqualTo(0);
    }

    @Test
    public void plusNumberSingle(){
        assertThat(number.calculate("3")).isEqualTo(3);
    }

    @Test
    public void plusNumbersWithoutCustom(){
        assertThat(number.calculate("1:2:3")).isEqualTo(6);
        assertThat(number.calculate("1,2,3")).isEqualTo(6);
    }

    @Test
    public void plusNumbersCustom(){
        assertThat(number.calculate("//;\n1;2;3")).isEqualTo(6);
        assertThat(number.calculate("//&\n1&2&3")).isEqualTo(6);
    }

    @Test
    public void exceptionNumber() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    assertThat(number.calculate("//;\n-1;2;3")).isEqualTo(4);
                }).withNoCause();
    }
}

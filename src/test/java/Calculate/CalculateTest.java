package Calculate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {

    @Test
    public void empty_String(){
        Calculate calculate=new Calculate();
        assertEquals(0,calculate.parser(""));
        assertEquals(0,calculate.parser(""));

    }

    @Test
    public void null_String(){
        Calculate calculate=new Calculate();
        assertEquals(0,calculate.parser(null));

    }
}

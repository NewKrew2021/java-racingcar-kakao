import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MyRandomTest {
    @Test
    public void isValidRange() {
        MyRandom random = new MyRandom();
        int num = random.nextInt();
        assertThat(0 <= num && num <= 9).isTrue();
    }
}

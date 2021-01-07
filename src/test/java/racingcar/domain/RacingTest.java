package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    public void CreateTest() {
        Racing racing = new Racing("ocean,pobi,tars", 5);
        assertThat(racing).isEqualTo(new Racing("ocean,pobi,tars", 5));
    }

    @Test
    public void remainTest() {
        Racing racing = new Racing("ocean,pobi,tars",1);
        assertThat(racing.isRoundRemain()).isTrue();
        racing.play();
        assertThat(racing.isRoundRemain()).isFalse();
    }

}

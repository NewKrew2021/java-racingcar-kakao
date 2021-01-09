package carRace.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {

    @Test
    public void getIntegerListTest(){
        RandomGenerator generator = new RandomGenerator();
        List<Integer> numbers = generator.getIntegerList(10);

        assertThat(numbers.size()).isEqualTo(10);
    }
}

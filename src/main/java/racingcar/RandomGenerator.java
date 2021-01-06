package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private Random random;

    public RandomGenerator() {
        this.random = new Random();
    }

    public List<Integer> generate(int size) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++)
            numbers.add(random.nextInt(10));

        return numbers;
    }
}

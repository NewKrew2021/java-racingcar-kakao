package carRace.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    private static final int BOUND_OF_RANDOM_NUMBER = 10;
    private final Random random;

    public RandomGenerator(){
        random = new Random();
    }

    public List<Integer> getIntegerList(int cnt){

        List<Integer> numbers = new ArrayList<>();

        for(int i = 0; i < cnt; i++){
            numbers.add(random.nextInt(BOUND_OF_RANDOM_NUMBER));
        }
        return numbers;
    }
}

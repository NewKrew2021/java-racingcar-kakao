package racingcar;

import java.util.Arrays;
import java.util.List;

public class Racingcar {
    private List<String> carList;

   public List<String> getName(String s) {
        return carList = Arrays.asList(s.split(","));
    }
}
package racingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public Parser() {
    }

    public List<String> parsing(String userInput) {
        String[] split = userInput.split(",");
        return Arrays.stream(split)
                     .map(String::trim)
                     .collect(Collectors.toList());
    }
}

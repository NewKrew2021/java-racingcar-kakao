package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter implements AbstractSplitter {
    public List<Integer> split(Input input) {
        if (input.isEmpty()) {
            return Arrays.asList(0);
        }

        String userInput = input.getInput();
        return Arrays.stream(userInput.split(",|:"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

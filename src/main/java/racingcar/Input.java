package racingcar;

import java.util.Arrays;
import java.util.List;

public class Input {
    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    public List<String> getSplitName() {
        return Arrays.asList(input.split(","));
    }
}

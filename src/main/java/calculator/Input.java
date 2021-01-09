package calculator;

import java.util.List;

public class Input {
    private final String userInput;
    private AbstractSplitter splitter;

    Input(String userInput) {
        this.userInput = userInput;

        splitter = new Splitter();
        if (userInput.contains("//"))
            splitter = new CustomSplitter();
    }

    private static void validate(List<Integer> list) {
        list.forEach(v -> {
            if (v < 0) {
                throw new IllegalArgumentException("음수가 포함되었습니다.");
            }
        });
    }

    public List<Integer> split() {
        List<Integer> list = splitter.split(this);
        validate(list);
        return list;
    }

    public String getInput() {
        return userInput;
    }

    public boolean isEmpty() {
        return userInput == null || userInput.isEmpty();
    }

    public int add() {
        int result = 0;
        for (int value : this.split()) {
            System.out.println(value);
            result += value;
        }
        return result;
    }
}
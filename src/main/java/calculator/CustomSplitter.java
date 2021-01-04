package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomSplitter implements AbstractSplitter {

    public List<Integer> split(Input input) {
        String userInput = input.getInput();
        Matcher m = Pattern.compile("//(.)\\n(.*)").matcher(userInput);
        System.out.println(input.getInput() + "1");
        if (m.find()) {
            System.out.println(input.getInput() + "2");
            String customDelimeter = m.group(1);
            String[] tokens = m.group(2).split(customDelimeter);

            return Arrays.stream(tokens)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }

        return Arrays.asList(0);
    }
}

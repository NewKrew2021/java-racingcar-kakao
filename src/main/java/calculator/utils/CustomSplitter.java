package calculator.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomSplitter implements Splitter {
    private static final String SPLIT_REGEX = "//(.)\\n(.*)";
    private static final Pattern pattern = Pattern.compile(SPLIT_REGEX);

    public List<Integer> split(String userInput) throws NumberFormatException{
        Matcher m = pattern.matcher(userInput);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return Arrays.stream(tokens)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        return Arrays.asList(0);
    }
}

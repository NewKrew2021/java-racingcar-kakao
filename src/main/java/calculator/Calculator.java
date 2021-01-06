package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private final static String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(parse(split(text)));
    }

    private static String[] split(String text) {
        Matcher m = getMatcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static Matcher getMatcher(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }

    private static List<Integer> parse(String[] texts){
        List<Integer> result = new ArrayList<>();
        for (String text : texts) {
            result.add(stringToInt(text));
        }

        if (hasNegative(result)) {
            throw new RuntimeException("minus error");
        }
        return result;
    }

    private static int stringToInt(String text){
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException("not integer error");
        }
    }

    private static boolean hasNegative(List<Integer> result) {
        return result.stream().anyMatch(no -> no < 0);
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }

    private static boolean isBlank(String text) {
        return (null == text || text.isEmpty());
    }
}

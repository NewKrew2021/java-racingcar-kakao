package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_SPLIT_DELIMITER = ",|:";

    public int calculate(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sumNumbers(mapNumbers(splitText(text)));
    }

    private String[] splitText(String text) {
        String delimiter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String textWithoutCustomDelimiter = m.group(2);
            delimiter += "|" + customDelimiter;
            return textWithoutCustomDelimiter.split(delimiter);
        }
        return text.split(delimiter);
    }

    private List<Integer> mapNumbers(String[] tokens) {
        List<Integer> result = new ArrayList<>();
        for (String token : tokens) {
            result.add(checkNumber(token));
        }
        return result;
    }

    private int checkNumber(String token) {
        int number;
        try {
            number = Integer.parseInt(token);
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private int sumNumbers(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

}

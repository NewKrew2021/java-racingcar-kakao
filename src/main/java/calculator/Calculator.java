package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    public List<String> split(String s) {
        String[] arr = s.split(",|:");
        List<String> result = Arrays.asList(arr);

        return result;
    }

    public List<Integer> change(List<String> list) {
        List<Integer> result = list.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i : result) {
            isPositive(i);
        }

        return result;
    }

    public void isPositive(int n) {
        if (n < 0)
            throw new RuntimeException();
    }

    public int sum(List<Integer> tmp) {
        int result = 0;

        for (int i = 0; i < tmp.size(); i++) {
            result += tmp.get(i);
        }

        return result;
    }

    public int extract(String s) {
        String[] tokens = null;
        int result = 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);

        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }

        for (int i = 0; i < tokens.length; i++) {
            result += Integer.parseInt(tokens[i]);
        }

        return result;
    }
}

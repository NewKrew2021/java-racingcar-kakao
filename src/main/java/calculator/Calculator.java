package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        String[] values = parse(text);
        return sum(checkNegative(toInts(values)));
    }

    private static int parseInt(String text) {
        int num = 0;

        try {
            num = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("계산기에 , : 를 제외한 문자는 입력이 불가능합니다.");
        }

        return num;
    }

    private static int[] toInts(String[] text) {
        int[] numbers = new int[text.length];
        for (int i = 0; i < text.length; i++) {
            numbers[i] = parseInt(text[i]);
        }
        return numbers;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static String[] split(String text) {
        return text.split(",|:");
    }

    private static String[] parse(String text){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return split(text);
    }

    private static int[] checkNegative(int[] numbers) {
        for (int number : numbers) {
            isMinus(number);
        }
        return numbers;
    }

    private static void isMinus(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}

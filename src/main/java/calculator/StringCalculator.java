package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int sum(String text){
        if(isaBoolean(text))
            return 0;
        return sum(toInt(getSplit(text)));
    }

    private static String[] getSplit(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        return text.split(",|:");
    }

    private static boolean isaBoolean(String text) {
        return text == null || text.isEmpty();
    }

    private static int[] toInt(String[] values){
        int[] numbers = new int[values.length];
        for(int i=0; i< values.length; i++){
            numbers[i] = Integer.parseInt(values[i]);
            checkNegative(numbers[i]);
        }
        return numbers;
    }

    private static void checkNegative(int number) {
        if(number < 0) throw new IllegalArgumentException();
    }

    private static int sum(int[] numbers){
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}

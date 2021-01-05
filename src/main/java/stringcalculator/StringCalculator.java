package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    static public int calculate(String data) throws RuntimeException {
        if(isBlank(data)){
            return 0;
        }
        return sum(stringsToInts(extract(data).split(extractSeparator(data))));
    }

    private static String extractSeparator(String data) {
        return ",|:" + addSeparator(data);
    }

    static private int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    static private boolean isBlank(String data) {
        return data == null || data.isEmpty();
    }

    static private int[] stringsToInts(String[] numbers){
        int[] result = new int[numbers.length];
        for(int i = 0 ; i < numbers.length ; ++i){
            result[i] = Integer.parseInt(numbers[i]);
            minusCheck(result[i]);
        }
        return result;
    }

    private static void minusCheck(int number) {
        if(number < 0){
            throw new RuntimeException();
        }
    }

    static private String addSeparator(String data){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(data);
        if (m.find()) {
            return "|" + m.group(1);
        }
        return "";
    }

    static private String extract(String data){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(data);
        if (m.find()) {
            return m.group(2);
        }
        return data;
    }
}
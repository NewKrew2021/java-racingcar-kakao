package stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int calculate(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }

        int result = 0;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(",|:|" + customDelimiter);
            for (String token : tokens) {
                result += Integer.parseInt(token);
            }
            return result;
        }

        String[] tokens = text.split(",|:");
        for (String token : tokens) {
            result += Integer.parseInt(token);
        }
        return result;
    }
}

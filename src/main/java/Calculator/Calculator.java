package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private String delimeter;
    private String parsedText;

    public Calculator() {
        this.delimeter = ",|:";
    }

    public int calculate(String originalText) {
        if (isNull(originalText)) {
            return 0;
        }
        parseText(originalText);
        return addNumbers(toInts(split()));
    }

    private boolean isNull(String text) {
        return text == null || text.isEmpty();
    }

    private void parseText(String originalText) {
        this.parsedText = originalText;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(originalText);
        if (m.find()) {
            this.delimeter = m.group(1);
            this.parsedText = m.group(2);
        }
    }

    private String[] split() {
        return this.parsedText.split(this.delimeter);
    }

    private int[] toInts(String[] stringArray) {
        int[] numbers = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            numbers[i] = Integer.parseInt(stringArray[i]);
            isNegative(numbers[i]);
        }
        return numbers;
    }

    private void isNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private int addNumbers(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}

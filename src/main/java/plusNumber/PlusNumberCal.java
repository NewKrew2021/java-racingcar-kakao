package plusNumber;

import java.util.regex.*;

public class PlusNumberCal {

    public int calculate(String str) {
        if (isBlank(str)) {
            return 0;
        }
        String[] numbers = mySplit(str);

        if(!checkValidNumbers(numbers)){
            throw new RuntimeException();
        }

        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += strToInt(number);
        }
        return result;
    }

    private boolean checkValidNumbers(String[] numbers){
        boolean result = true;
        for (String number : numbers) {
            result = result & checkValidNumber(number);
        }
        return result;
    }

    private boolean checkValidNumber(String str) {
        return str.matches("[+]?\\d*(\\.\\d+)?");
    }

    private int strToInt(String number) {
        return Integer.parseInt(number);
    }

    private boolean isBlank(String str) {
        return str == null || str.isEmpty();
    }

    private String[] mySplit(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return str.split(",|:");
    }
}

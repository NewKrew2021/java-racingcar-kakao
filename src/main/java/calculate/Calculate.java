package calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {
    public int parser(String formula) throws RuntimeException {

        if (isNull(formula) || isEmpty(formula)) {
            return 0;
        }
        Integer value = Integer.parseInt(formula);
        raiseWhenValueIsMinus(value);
        return value;
    }

    public void raiseWhenValueIsMinus(int value) {

        if (value < 0) {
            throw new RuntimeException("Negative value");
        }
    }

    public boolean isEmpty(String formula) {

        return formula.isEmpty();
    }

    public boolean isNull(String formula) {

        return null == formula;
    }

    public List<Integer> splitToInt(String formula) {

        String[] numbers = formula.split(",|:");
        List<Integer> list = new ArrayList<Integer>();
        for (String number : numbers) {
            list.add(parser(number));
        }
        return list;
    }

    public int calculating(String formula) {

        formula = customToDefault(formula);
        List<Integer> list = splitToInt(formula);
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        return sum;
    }

    public String customToDefault(String formula) {

        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(formula);
        if (m.find()) {
            return replaceSeparator(formula, m.group(1));
        }
        return formula;
    }

    public String replaceSeparator(String formula, String separator) {

        String[] str = formula.split("\n");
        return str[1].replace(separator, ",");
    }


}

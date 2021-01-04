package Calculate;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    public int parser(String formula) {
        if(isNull(formula)||isEmpty(formula)){
            return 0;
        }

        return Integer.parseInt(formula);
    }


    public boolean isEmpty(String formula){
        return formula.isEmpty();
    }

    public boolean isNull(String formula){
        return null==formula;
    }
    public List<Integer> splitToInt(String formula){
        String[] numbers=formula.split(",|:");
        List<Integer> list =new ArrayList<Integer>();
        for (String number : numbers) {
            list.add(parser(number));
        }
        return list;
    }

    public int calculating(String formula) {
        List<Integer> list =splitToInt(formula);
        int sum=0;
        for (int number: list) {
            sum+=number;
        }
        return sum;
    }
}

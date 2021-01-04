package Calculator;

public class Calculator {

    String[] splitString(String src, String regex) {
        return src.split(regex);
    }

    static int splitAndSum(String src){
        if(src == null || src.isEmpty()){
            return 0;
        }

        return sum(toInts(split(src)));
    }

    private static String[] split(String src){
        return src.split(",|:");
    }

    private static int[] toInts(String[] array){
        int[] numArr = new int[array.length];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(array[i]);
        }

        return numArr;
    }

    private static int sum(int[] array){
        int sum = 0;
        for(Integer number : array){
            sum += number;
        }

        return sum;
    }

    public static void main(String[] args) {
    }
}

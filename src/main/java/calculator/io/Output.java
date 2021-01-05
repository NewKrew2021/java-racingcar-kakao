package calculator.io;

public class Output {
    public static void askInput() {
        System.out.print(Text.ASK_STRING_TO_CALCULATE);
    }

    public static void printResult(int result) {
        System.out.println(Text.RESULT + result);
    }

    public static void printError(Exception e){
        System.out.println(e.getMessage());
    }
}

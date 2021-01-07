package view;

import java.util.Scanner;

public class RacingGameView {
    private static final Scanner sc = new Scanner(System.in);

    public static void startMessagePrint() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void tryMessagePrint() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void runResult(){
        System.out.println("\n실행 결과");
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static String getCarNames(){
        return sc.next();
    }

    public static int getProgressNumber(){
        return sc.nextInt();
    }
}

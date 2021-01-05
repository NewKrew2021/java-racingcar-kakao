package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGameApp {
    private static RacingGame racing;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean flag;
        String[] names;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String input = scan.nextLine();
            flag = makeCars(input);
        }while(!flag);



        System.out.println("시도할 회수는 몇회인가요?");
        int count = scan.nextInt();

        System.out.println("\n실행 결과");

        for(int i=0; i< count; i++){
            racing.moveCars();
            racing.printCarsStatus();
            System.out.println();
        }

        ArrayList<String> winners = racing.getWinners();
        String result = String.join(", ", winners);
        System.out.println(result + "가 최종 우승했습니다.");

    }

    private static boolean makeCars(String input) {
        try {
            String[] names = racing.stringToNames(input);
            racing = new RacingGame(names);
            return true;

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}

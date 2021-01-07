package racingcar.view;

import java.util.List;
import java.util.Scanner;

public class UserView {

    public static String enterCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int enterRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printProcessTitle() {
        System.out.println("실행 결과");
    }

    public static void printWinnerName(List<String> names) {
        System.out.print(String.join(",", names));
        System.out.println("가 최종 우승했습니다.");
    }
}

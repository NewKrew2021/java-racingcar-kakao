import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String STRING_INSERT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String STRING_HOW_MANY_TIMES_TRIES = "시도할 회수는 몇회인가요?";

    public static List<String> readNames() {
        System.out.println(STRING_INSERT_CAR_NAMES);
        return parseString(scanner.nextLine());
    }

    public static int readRound() {
        System.out.println(STRING_HOW_MANY_TIMES_TRIES);
        return scanner.nextInt();
    }

    private static List<String> parseString(String nameString) {
        return Arrays.asList(nameString.split(","));
    }
}

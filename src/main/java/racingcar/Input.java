package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getGameTime(){
        return scanner.nextInt();
    }

    public static List<String> getNames(){
        return getSplitName(scanner.nextLine());
    }

    public static List<String> getSplitName(String input) {
        return Arrays.asList(input.split(","));
    }
}

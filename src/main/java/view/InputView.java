package view;

import domain.RacingGame;

import java.util.Arrays;
import java.util.Scanner;

final class LengthOfNameException extends Exception {
    public LengthOfNameException() { super("이름은 최대 5자 이내로 작성하세요."); }
}

final class NumberOfNamesException extends Exception {
    public NumberOfNamesException() {
        super("이름은 최소 2개 이상 작성하세요.");
    }
}

final class PostiveIntegerException extends Exception {
    public PostiveIntegerException() { super("양의 정수를 작성하세요."); }
}

public final class InputView {
    private InputView() {}

    public static String[] getNames() throws Exception {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String text = new Scanner(System.in).nextLine();
        String[] names;
        while (true) {
            try {
                names = parseNames(text);
                break;
            } catch (LengthOfNameException | NumberOfNamesException e) {
                System.out.println(e.getMessage());
                text = new Scanner(System.in).nextLine();
            }
        }
        return names;
    }

    public static int getFinalRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        int finalRound;
        while(true){
            try {
                finalRound = Integer.parseInt(new Scanner(System.in).nextLine());
                if(finalRound < 0) {
                    throw new PostiveIntegerException();
                }
                break;
            } catch (PostiveIntegerException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("숫자를 작성하세요.");
            }
        }
        return finalRound;
    }


    public static String[] parseNames(String text) throws Exception {
        String[] names = text.split(",");

        if (!isValidNumberOfNames(names)) {
            throw new NumberOfNamesException();
        }

        if (!isValidLengthOfEachName(names)) {
            throw new LengthOfNameException();
        }

        return names;
    }

    private static boolean isValidNumberOfNames(String[] names) {
        return (names != null) && (names.length >= RacingGame.MIN_NUM_NAMES);
    }

    private static boolean isValidLengthOfEachName(String[] names) {
        return Arrays.stream(names)
                .noneMatch(name -> name.isEmpty() || (name.length() > RacingGame.MAX_LEN_NAME));
    }
}
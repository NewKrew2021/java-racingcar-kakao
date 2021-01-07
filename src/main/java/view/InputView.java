package view;

import commons.*;
import domain.RacingGame;

import java.util.Scanner;

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
                    throw new NegativeIntegerException();
                }
                break;
            } catch (NegativeIntegerException e) {
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

        for(String name : names){
            if(!isValidLengthOfName(name)){
                throw new LengthOfNameException(name);
            }
        }

        return names;
    }

    private static boolean isValidNumberOfNames(String[] names) {
        return (names != null) && (names.length >= RacingGame.MIN_NUM_CARS);
    }

    private static boolean isValidLengthOfName(String name) {
        return !name.isEmpty() && (name.length() <= RacingGame.MAX_LEN_NAME);
    }
}
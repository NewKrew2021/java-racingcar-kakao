package racingcar;

import java.util.Scanner;

public class RacingGameInput {
    private static final int MAX_NAME_LENGTH = 5;
    private final Scanner scan;
    private Boolean errorFlag;

    public RacingGameInput(){
        scan = new Scanner(System.in);
    }

    public String[] carNameInput(){
        errorFlag = false;
        String[] names;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String input = scan.nextLine();
            names = getNames(input);
        }while(errorFlag);
        return names;
    }

    public int countInput(){
        System.out.println("시도할 회수는 몇회인가요?");
        int count = scan.nextInt();
        return count;
    }

    private String[] getNames(String input) {
        try {
            String[] names = stringToNames(input);
            errorFlag = false;
            return names;

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            errorFlag = true;
            return null;
        }
    }

    public static String[] stringToNames(String input) {
        if (Utils.isBlank(input))
            throw new IllegalArgumentException("한대 이상의 자동차를 입력해주세요.");
        String[] names = input.split(",");
        for (String name : names) {
            checkNameLength(name);
        }
        return names;
    }

    public static void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException("차 이름은 5자 이하여야 합니다.");
    }

}

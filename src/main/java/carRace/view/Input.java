package carRace.view;

import carRace.domain.Cars;
import carRace.validations.InputChecker;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static Cars getCarsFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String[] names = split(scanner.nextLine());

        if(InputChecker.isValid(names)){
            return new Cars(names);
        }

        return retryGetCarsFromUser();
    }

    private static Cars retryGetCarsFromUser(){
        String[] names;

        do {
            System.out.println("이름이 잘못되었습니다. 다시 입력해주세요(이름은 쉼표(,)를 기준으로 구분)");
            names = split(scanner.nextLine());
        }while(!InputChecker.isValid(names));

        return new Cars(names);
    }

    private static String[] split(String userInput) {
        return userInput.split(",");
    }

    public static int getNumOfRepeatFromUser() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}

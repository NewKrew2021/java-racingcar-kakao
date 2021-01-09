package carRace.view;

import carRace.utils.StringUtil;
import carRace.domain.Winners;
import carRace.controller.GameController;
import carRace.domain.Cars;
import carRace.dtos.CarDTOs;
import carRace.validations.InputChecker;

import java.util.List;
import java.util.Scanner;

public class GameUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GameController game = new GameController();
        game.run();
    }

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

    public static void printStartMessage() {
        System.out.println("실행 결과");
    }

    public static void printAllCars(Cars cars) {
        CarDTOs informations = cars.getCarInformations();

        for(int i = 0; i < informations.size(); i++){
            String name = informations.getNameOf(i);
            int location = informations.getLocationOf(i);

            String statusOfOneCar = stringBuildForOneCar(name, location);
            System.out.println(statusOfOneCar);
        }

        System.out.println();
    }

    private static String stringBuildForOneCar(String name, int location){
        String builded = name + " : ";
        for(int i = 0; i < location; i++){
            builded += '-';
        }
        return builded;
    }

    public static void printWinners(Winners winners) {
        List<String> names = winners.getWinnersNames();

        String formattedNames = names.get(0);
        for(int i = 1; i < names.size(); i++){
            formattedNames += ", " + names.get(i);
        }

        System.out.println(formattedNames + " 가 최종 우승했습니다.");
    }
}

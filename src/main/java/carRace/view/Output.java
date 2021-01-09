package carRace.view;

import carRace.domain.Cars;
import carRace.domain.Winners;
import carRace.dtos.CarDTOs;

import java.util.List;

public class Output {

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

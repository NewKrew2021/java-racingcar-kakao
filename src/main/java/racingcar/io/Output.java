package racingcar.io;

import racingcar.domain.Car;

import java.util.List;

public class Output {
    private static final char PROGRESS_CHAR = '-';
    private static final String WINNER_DELIMITER = ", ";
    private static final String CAR_LOCATION_DELIMITER = " : ";

    public static void askCarsName(){
        System.out.println(Text.REQUEST_CARS_NAME);
    }

    public static void askGameTime(){
        System.out.println(Text.REQUEST_SIMULATION_TIME);
    }

    public static void printSimulationResults(List<Car> cars){
        System.out.println(Text.SIMULATION_RESULT);
        for(Car car: cars){
            printCarLocation(car);
        }
        System.out.println();
    }

    private static void printCarLocation(Car car) {
        System.out.print(car.getName() + CAR_LOCATION_DELIMITER);
        printLocation(car.getLocation());
        System.out.println();
    }

    public static void printLocation(int location){
        for (int i = 0; i <= location; ++i) {
            System.out.print(PROGRESS_CHAR);
        }
    }

    public static void printWinner(List<String> winners){
        String joinedWinners = String.join(WINNER_DELIMITER, winners);
        System.out.println(joinedWinners + Text.IS_THE_WINNER);
    }

    public static void printError(Exception e){
        System.out.println(e.getMessage());
    }
}

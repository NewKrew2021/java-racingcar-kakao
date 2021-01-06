package carracing.ui;

import carracing.domain.Car;
import carracing.utils.CarRacingProgramPhrases;

import java.util.List;

public class CarRacingProgramUI {

   public static void printCarInputNamesPharse(){
       System.out.println(CarRacingProgramPhrases.CAR_NAMES_INPUT_PHRASE);
   }

    public static void printRaceCountPhrase(){
        System.out.println(CarRacingProgramPhrases.RACE_COUNT_PHRASE);
    }

    public static void printResultPharse(){
        System.out.println(CarRacingProgramPhrases.RESULT_PHRASE);
    }

    public static void printWinnerPharse(List<String> winners){
        StringBuilder winnerBuilder = new StringBuilder();

        for (int i = 0; i < winners.size()-1; i++) {
            winnerBuilder.append(winners.get(i));
            winnerBuilder.append(", ");
        }
        winnerBuilder.append(winners.get(winners.size()-1));

        winnerBuilder.append(CarRacingProgramPhrases.WINNER_PHRASE);

        System.out.println(winnerBuilder.toString());
    }

    public static void printCarPosition(Car car){
        System.out.println(car.getCarInfoString());
    }

    public static void printBlankLine(){
        System.out.println();
    }
}

package racingcar.io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getGameTime(){
        int gameTime;
        try {
            gameTime = scanner.nextInt();
        } catch (Exception e){
            throw new IllegalStateException(Text.ILLEGAL_GAME_TIME);
        }
        validateGameTime(gameTime);
        return gameTime;
    }

    private static void validateGameTime(int gameTime) {
        if(gameTime <= 0){
            throw new IllegalStateException(Text.ILLEGAL_GAME_TIME);
        }
    }

    public static List<String> getNames(){
        String names;
        try {
            names = scanner.nextLine();
        } catch (Exception e){
            throw new IllegalStateException(Text.ILLEGAL_CAR_NAMES);
        }
        validateNames(names);
        return splitName(names);
    }

    private static void validateNames(String names) {
        if(names.isEmpty()){
            throw new IllegalStateException(Text.ILLEGAL_CAR_NAMES);
        }
    }

    public static List<String> splitName(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}

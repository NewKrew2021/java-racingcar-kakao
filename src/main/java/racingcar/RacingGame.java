package racingcar;

public class RacingGame {
    public static String[] stringToNames(String input){
        if(isBlank(input))
            throw new IllegalArgumentException();
        return input.split(",");
    }

    private static boolean isBlank(String input) {
        return input.equals("") || input == null;
    }
}

package racingcar;

public class RacingGame {
    Car[] cars;

    public static String[] stringToNames(String input){
        if(isBlank(input))
            throw new IllegalArgumentException("ERROR:한대 이상의 자동차를 입력해주세요.");
        return input.split(",");
    }

    public void makeCars(String[] names){
        cars = new Car[names.length];
        for(int i=0; i< names.length;i++){
            cars[i] = new Car();
            cars[i].setName(names[i]);
        }
    }

    private static boolean isBlank(String input) {
        return input.equals("") || input == null;
    }

}

package racingcar.domain;


public class RacingGame {
    private Cars cars;
    private int tryNo;

    public RacingGame(String[] names, int tryNo){
        cars = new Cars(names);
        this.tryNo = tryNo;
    }

    private int getRandomNo() {
        return (int) (Math.random() * 10);
    }
}
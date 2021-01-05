package racingcar;


public class RandomNumber {
    static int Num;

    public void tryNum(Racingcar newRacingcar){
        for (int i = 0; i < Race.tryNum; i++) {
            newRacingcar.setCarLoc(this);
            newRacingcar.printCarLoc();
        }
        newRacingcar.winner();
    }

    public CarStatus setDirection() {
        setRandomNum();

        return direction();
    }

    int setRandomNum() {
        return this.Num = (int)(Math.random()*10);
    }

    CarStatus direction() {
        if (this.Num >= 4){
            return CarStatus.Go;
        }

        return CarStatus.Stop;
    }
}

package racingcar;

import java.util.Random;

public class RandomNumber {
    static int Num;

    int generate() {
        return this.Num = (int)(Math.random()*10);
    }


    public CarStatus direction() {
        if (this.Num >= 4){
            return CarStatus.Go;
        }
        return CarStatus.Stop;
    }
}

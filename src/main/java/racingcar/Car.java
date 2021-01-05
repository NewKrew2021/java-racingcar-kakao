package racingcar;

import java.util.List;

public class Car {
    private String name;
    private static String winner = "";
    private int loc;
    private static int winnerLoc = 0;

    public Car(String name, int loc){
        this.name = name;
        this.loc = loc;
    }

    public String getName(){
        return this.name;
    }

    public int getLoc(){
        return this.loc;
    }

    public boolean carNameLengthCheck(){
        return this.name.length() <= 5;
    }

    public String getWinnerName(){
        return winner;
    }
    public void setLoc(int loc){
        this.loc += loc;
    }

    public void findWinnerLoc(){
        if (winnerLoc < this.loc){
            winnerLoc = this.loc;
        }
    }

    public void winnerName(){
        if (winnerLoc == this.loc){
            winner += this.name + " ";
        }
    }
}

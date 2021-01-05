package racingcar;

import java.util.List;

public class Car {
    private String name;
    private int loccation;

    public Car(String name){
        this.name = name;
        this.loccation = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getLoccation(){
        return this.loccation;
    }

    public void move(int condition){
        loccation += condition;
    }

    public void printLocation(){

    }

//
//    public int getLoc(){
//        return this.loc;
//    }
//
//    public boolean carNameLengthCheck(){
//        return this.name.length() <= 5;
//    }
//
//    public String getWinnerName(){
//        return winner;
//    }
//    public void setLoc(int loc){
//        this.loc += loc;
//    }
//
//    public void findWinnerLoc(){
//        if (winnerLoc < this.loc){
//            winnerLoc = this.loc;
//        }
//    }
//
//    public void winnerName(){
//        if (winnerLoc == this.loc){
//            winner += this.name + " ";
//        }
//    }
}

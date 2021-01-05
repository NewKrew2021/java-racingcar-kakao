package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Racingcar {
    private List<String> carList;
    
    List<String> getCarName(String s) {
        return this.carList = Arrays.asList(s.split(","));
    }

    boolean carNameCheck(){
        return this.carList.size() <= 5;
    }
}
package racingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public Parser() {
    }

    public List<String> parsing(String userInput) throws RuntimeException {
        String[] split = userInput.split(",");
        return Arrays.stream(split)
                     .map(String::trim)
                     .map(this::isLong)
                     .collect(Collectors.toList());
    }

    public String isLong(String carName){

        if(carName.length()>5){
            throw new RuntimeException("이름이 너무 깁니다");
        }
        return carName;
    }


}

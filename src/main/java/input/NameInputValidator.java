package input;

import domain.Car;

public class NameInputValidator implements UserInputValidator{
    @Override
    public void validate(String stringFromUser) throws Exception {
        String namesArray[] = stringFromUser.split(",");
        for (int i = 0; i < namesArray.length; i++) {
            new Car(namesArray[i]);
        }
    }
}

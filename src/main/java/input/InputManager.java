package input;

import java.util.Scanner;

public class InputManager {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public String getFromUser(String comment, UserInputValidator validator) {
        System.out.println(comment);
        String fromUser = scanner.next();
        try {
            validator.validate(fromUser);
            return fromUser;
        } catch (Exception e) {
            return getFromUser(comment, validator);
        }
    }
}

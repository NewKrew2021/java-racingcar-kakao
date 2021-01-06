package domain;

import exception.InvalidCarNameException;

public class CarName {
    private static final int NAME_LIMIT = 5;
    private final String data;

    public CarName(String data) {
        if (data.length() > NAME_LIMIT) {
            throw new InvalidCarNameException();
        }
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}

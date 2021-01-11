package carRace;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static void validate(String name) {
        if(!isAlpha(name)) {
            throw new RuntimeException(String.format("차 이름은 알파벳이어야 합니다 - error name : \"%s\"", name));
        }
        if(!allowedLength(name)) {
            throw new RuntimeException(String.format("차 이름은 1글자 이상 5글자 이하여야 합니다 - error name : \"%s\"", name));
        }
    }

    private static boolean allowedLength(String name) {
        return MAX_NAME_LENGTH >= name.length() && name.length() > 0;
    }

    private static boolean isAlpha(String name) {
        boolean result = true;
        for (char c : name.toCharArray()) {
            result &= Character.isAlphabetic(c);
        }
        return result;
    }
}

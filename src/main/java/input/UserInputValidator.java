package input;

@FunctionalInterface
public interface UserInputValidator {
    public void validate(String str) throws Exception;
}

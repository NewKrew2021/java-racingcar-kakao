import java.util.Random;

public class NumberUtil {

    public static int createRandomNumber() {

        Random random = new Random();

        return random.nextInt(10);
    }
}

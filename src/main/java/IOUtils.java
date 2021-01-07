import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtils {
    public static String getNames() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            return br.readLine();
        } catch (IOException e) {
            throw e;
        }
    }

    public static int getTrial() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("시도할 회수는 몇회인가요?");
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw e;
        }
    }

    public static void print(String input) {
        System.out.print(input);
    }

    public static void println(String input) {
        System.out.println(input);
    }
}

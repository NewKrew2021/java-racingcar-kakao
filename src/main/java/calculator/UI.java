package calculator;

import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input input = null;
        String in = "";

        System.out.println("계산할 문자 입력 >> ");
        in = scanner.next();

        input = new Input(in);
        System.out.println("결과 >> " + input.add());
    }
}

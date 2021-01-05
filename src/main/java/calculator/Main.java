package calculator;

import calculator.domain.Calculator;
import calculator.io.Output;

public class Main {
    public static void main(java.lang.String[] args) {
        try {
            Calculator.addIO();
        } catch (Exception e) {
            Output.printError(e);
        }
    }
}

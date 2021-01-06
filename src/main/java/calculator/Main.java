package calculator;

import calculator.domain.CalculatorController;
import calculator.io.Output;

public class Main {
    public static void main(java.lang.String[] args) {
        try {
            CalculatorController.addIO();
        } catch (Exception e) {
            Output.printError(e);
        }
    }
}

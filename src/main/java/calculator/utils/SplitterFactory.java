package calculator.utils;

public class SplitterFactory {
    private static final String CUSTOM_SPLITTER_INDICATOR = "//";

    public static Splitter getSplitter(String userInput){
        if (userInput.startsWith(CUSTOM_SPLITTER_INDICATOR))
            return new CustomSplitter();
        return new SplitterImpl();
    }
}

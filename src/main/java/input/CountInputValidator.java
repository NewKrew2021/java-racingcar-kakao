package input;

public class CountInputValidator implements UserInputValidator{
    @Override
    public void validate(String str) throws Exception {{
        if (str == null)
            throw new Exception();
        int num = Integer.parseInt(str);
        if (num <= 0)
            throw new Exception();
    };
    }
}

package carracing.view;

import carracing.domain.Car;

public class CarInfoPrint {
    private static final String INFO_COLON = " : ";
    private static final String POSITION_MARKER = "-";

    public static void showCarInfo(Car car){
        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append(car.getName() + INFO_COLON);
        for (int i = 0; i < car.getPosition(); i++) {
            infoBuilder.append(POSITION_MARKER);
        }

        System.out.println(infoBuilder.toString());
    }
}

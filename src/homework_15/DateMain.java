package homework_15;

import java.text.ParseException;

public class DateMain {
    public static void main(String[] args) throws ParseException {

        DateService dateService = new DateService();
        dateService.printNameDayOfWeek("01-08-2012");
        dateService.printDateOfNextTuesday();

    }

}

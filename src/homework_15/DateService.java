package homework_15;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateService {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public void printNameDayOfWeek(String input) throws ParseException {
        Date date = dateFormat.parse(input);
        DateFormat format = new SimpleDateFormat("EEEE");
        String dayName = format.format(date);
        System.out.println("Введённый день (" + dateFormat.format(date) + ") : " + dayName);
    }

    //если вторник сегодня, то будет отображаться дата следующего вторника
    public void printDateOfNextTuesday() {
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        calendar.setTime(time);
        int todayDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysFromTuesday = Calendar.TUESDAY - todayDayOfWeek;

        int numberOfDays = daysFromTuesday > 0 ? daysFromTuesday : 7 + daysFromTuesday;

        calendar.add(Calendar.DAY_OF_WEEK, numberOfDays);
        System.out.println("Дата следующего вторника: " + dateFormat.format(calendar.getTime()));
    }

}

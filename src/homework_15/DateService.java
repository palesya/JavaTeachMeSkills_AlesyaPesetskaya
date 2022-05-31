package homework_15;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateService {

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public void printNameDayOfWeek(String input) throws ParseException {
        Date date = sdf.parse(input);
        DateFormat format = new SimpleDateFormat("EEEE");
        String dayName = format.format(date);
        System.out.println("Введённый день ("+sdf.format(date)+") : " + dayName);
    }

    //если вторник сегодня, то будет отображаться дата следующего вторника
    public void printDateOfNextTuesday() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Date date = sdf.parse("31-05-2022");
        calendar.setTime(date);
        int todayDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int days = Calendar.TUESDAY - todayDayOfWeek;
        if (days > 0) {
            calendar.add(Calendar.DAY_OF_WEEK, days);
        }else{
            calendar.add(Calendar.DAY_OF_WEEK, 7+days);
        }
        System.out.println("Дата следующего вторника: "+sdf.format(calendar.getTime()));
    }

}

package lecture_9;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);

        SimpleDateFormat dateFormat=new SimpleDateFormat();
        System.out.println(dateFormat.format(date));

        SimpleDateFormat dateFormat1=new SimpleDateFormat("dd MMMM");
        System.out.println(dateFormat1.format(date));

        SimpleDateFormat dateFormat2=new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(dateFormat2.format(date));

        SimpleDateFormat dateFormat3=new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        System.out.println(dateFormat3.format(date));

        System.out.println("-------------------------------------");

        LocalDate localDate= LocalDate.now();
        System.out.println(localDate);

        LocalDate localDate1= LocalDate.of(2012,03,12);
        System.out.println(localDate1);
        System.out.println(localDate1.getDayOfWeek());
        System.out.println(localDate1.plusDays(12));

        System.out.println("-------------------------------------");

        LocalTime time= LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime=LocalDateTime.now();
        System.out.println(dateTime);

    }
}

import com.tms.service.RacingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms");

        RacingService racingService = context.getBean(RacingService.class);
        racingService.startRace();
    }
}

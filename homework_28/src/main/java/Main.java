import com.tms.service.RacingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        RacingService racingService = context.getBean(RacingService.class);
        racingService.startRace();
    }
}

import com.tms.service.RacingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext("com.tms");
        context.registerShutdownHook();

        RacingService racingService = context.getBean(RacingService.class);
        racingService.startRace();
    }
}

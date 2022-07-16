import com.tms.repository.PairDBRepository;
import com.tms.service.RacingService;
import com.tms.service.UserBetService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        RacingService racingService = context.getBean(RacingService.class);
        UserBetService userBetService = context.getBean(UserBetService.class);
        PairDBRepository repository = context.getBean(PairDBRepository.class);
        userBetService.askForPairNumber();
        repository.printPairsInfo();
        racingService.startRace();
    }
}

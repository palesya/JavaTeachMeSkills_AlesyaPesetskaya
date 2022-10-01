import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp {

    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {

        logger.info("hello");
        logger.debug("debug");
        logger.error("error");
        System.out.println("this is the beginning");

    }
}

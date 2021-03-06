import org.springframework.context.support.ClassPathXmlApplicationContext;
import quotes.implementations.TerminatorQuoter;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(TerminatorQuoter.class).sayQuote();
    }
}

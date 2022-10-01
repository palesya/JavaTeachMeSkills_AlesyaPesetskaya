
import org.junit.jupiter.api.*;

public class MathServiceTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("before all");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("after all");
    }


    @BeforeEach
    void printBefore(){
        System.out.println("Before");
    }

    @AfterEach
    void printAfter(){
        System.out.println("After");
    }

    @Test
    void division() {
        MathService mathService = new MathService();
        Integer v1 = 20;
        Integer v2 = 5;
        Integer expected = 4;
        Integer result = mathService.division(v1, v2);
        Assertions.assertEquals(expected,result);
    }

    @Test
    void division2() {
        MathService mathService = new MathService();
        Integer v1 = 20;
        Integer v2 = 3;
        Integer expected = 6;
        Integer result = mathService.division(v1, v2);
        Assertions.assertEquals(expected,result);
    }

    @Test
    void divisionByZero() {
        MathService mathService = new MathService();
        Integer v1 = 20;
        Integer v2 = null;
        Integer result = mathService.division(v1, v2);
        Assertions.assertNull(result);
    }

    @Test
    void divisionByZero2() {
        MathService mathService = new MathService();
        Integer v1 = 20;
        Integer v2 = 0;
        Integer result = mathService.division(v1, v2);
        Assertions.assertNull(result);
    }
}

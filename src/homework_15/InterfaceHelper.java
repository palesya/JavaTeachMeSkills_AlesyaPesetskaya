package homework_15;

public class InterfaceHelper {

    private int factorial(int num) {
        if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return 1;
        }
    }

    public void printFactorial(String value) {
        int result = factorial(Integer.parseInt(value));
        System.out.println("Factorial of " + value + " is " + result);
    }

    public void printConvertedLine(String value) {
        String reversedLine = new StringBuilder(value).reverse().toString();
        System.out.println("Line was reversed to:\n" + reversedLine);
    }

}

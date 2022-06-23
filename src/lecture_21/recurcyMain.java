package lecture_21;

public class recurcyMain {
    public static void main(String[] args) {

        String string = "vbtwrnuaetron'wbtsyopn'r";
        char symbol = 't';
        int calculate = calculate(string, symbol);
        System.out.println(calculate);
    }

    static int calculate(String text, char ch) {
        int i = text.indexOf(ch);
        String substring;
        if (i >= 0) {
            substring = text.substring(i + 1);
            return 1 + calculate(substring, ch);
        }
        else return 0;
    }
}

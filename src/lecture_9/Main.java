package lecture_9;

import lecture_9.Flowers.Roses;
import lecture_9.Flowers.Sunflowers;
import lecture_9.Flowers.Tullips;

public class Main {
    public static void main(String[] args) {
        Flower[] bouquet1 = {new Sunflowers("Belarus", 5, 20), new Sunflowers("Belarus", 5, 20), new Sunflowers("Belarus", 5, 20)};
        Flower[] bouquet2 = {new Sunflowers("Belarus", 5, 20), new Roses("Belgium", 6, 10), new Tullips("Georgia", 8, 5)};
        Flower[] bouquet3 = {new Tullips("Georgia", 8, 5), new Tullips("Georgia", 8, 5), new Tullips("Georgia", 8, 5), new Roses("Belgium", 6, 10), new Tullips("Georgia", 8, 5)};

        System.out.println("Total price of bouquet1 = " + countPrice(bouquet1));
        System.out.println("Total price of bouquet2 = " + countPrice(bouquet2));
        System.out.println("Total price of bouquet3 = " + countPrice(bouquet3));
        System.out.println("Total number of sold flowers = " + Flower.getCount());
    }

    public static int countPrice(Flower[] bouquet) {
        int price = 0;
        for (Flower el : bouquet) {
            price += el.getPrice();
        }
        return price;
    }

}

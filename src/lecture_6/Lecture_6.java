package lecture_6;

public class Lecture_6 {
    public static void main(String[] args) {
        Product product=new Product("Phone");
        System.out.printf("Product name is %s and product price is %d",product.getName(),product.getPrice());
        System.out.println();
        System.out.println("===========================");
        Product product1=new Product("Apple",5);
        System.out.printf("Product name is %s and product price is %d",product1.getName(),product1.getPrice());
        System.out.println();
        System.out.println("===========================");
        Product product2=new Product(10);
        System.out.printf("Product name is %s and product price is %d",product2.getName(),product2.getPrice());
        product2.setName("Banana");
        System.out.println();
        System.out.println("===========================");
        System.out.printf("Product name is %s and product price is %d",product2.getName(),product2.getPrice());

        System.out.println();
        System.out.println("===========================");
        product.setTax("UAE");
        System.out.printf("Tax for product %d",product.getTax());

        System.out.println();
        System.out.println("===========================");
        product.setTax(10,2);
        System.out.printf("Tax for product %d",product.getTax());

        System.out.println();
        System.out.println("===========================");
        product.setTax(1,2,3,4,5,6);
        System.out.printf("Tax for product %d",product.getTax());
    }
}

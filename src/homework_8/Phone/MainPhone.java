package homework_8.Phone;

public class MainPhone {
    public static void main(String[] args) {
        Phone phone = new Phone(1232345, "IPhone", 130);
        Phone phone1 = new Phone(143654, "Samsung", 120);
        Phone phone2 = new Phone(1673456, "Huawei", 160);
        Phone[] phones = {phone, phone1, phone2};
        for (Phone el : phones) {
            System.out.println(el);
        }

        for (Phone el : phones) {
            System.out.println("-------------------");
            el.receiveCall("Anna");
            System.out.println(el.getNumber());
        }

        System.out.println("-------------------");
        phone.receiveCall("Ivan", 1111111);

        System.out.println("-------------------");
        phone1.sendMessage(1111111,2222222,3333333,4444444,6666666,9999999);
    }
}

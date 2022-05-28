package lecture_14.comparator;

public class MainGenerics {
    public static void main(String[] args) {

        DBService<User, String> userService = new UserDBService();
        DBService<Car, Long> carService = new CarDBService();

        User ee = userService.get("ee");
        System.out.println(ee);

        carService.save(new Car());

        User user = new User("Test", 30);
        Car car = new Car();

        TestService testService = new TestService();
        User user1 = testService.get(user);
        Car car1 = testService.get(car);

    }
}

package Patterns.Creational.Builder;

public class User {

    private String name;
    private Integer age;
    private String address;

    public static final class Builder{

        private User user;

        public Builder() {
            user = new User();
        }

        public Builder name(String name){
            user.name=name;
            return this;
        }

        public Builder address(String address){
            user.address=address;
            return this;
        }

        public Builder age(Integer age){
            user.age=age;
            return this;
        }

        public User build(){
            return user;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

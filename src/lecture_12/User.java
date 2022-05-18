package lecture_12;

import java.io.Serializable;

public class User extends Person implements Serializable {

    private String name;
    private String sex;
    private Address address;

    public User() {
    }

    public User(String name, String sex, Address address) {
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", " + address +
                '}';
    }
}

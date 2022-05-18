package lecture_12;

import java.io.Serializable;

public class Address implements Serializable {
    public String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "city = " + city;
    }
}

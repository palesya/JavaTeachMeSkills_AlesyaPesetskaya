package lecture_16.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        User user = new User("Ivan", 20);

        Country country1 = new Country("Belarus",
                new City("Minsk",
                        new Street("Artyoma",
                                new Home(28))));


        Country country2 = new Country("Georgia",
                new City("Batumi",
                        new Street("Main",
                                new Home(41))));

        List<Country> countryList = new ArrayList<>();
        countryList.add(country1);
        countryList.add(country2);


        if(country2 !=null){
            City city = country2.getCity();
            if(city!=null){
                Street street = city.getStreet();
                if(street!=null){
                    Home home = street.getHome();
                    if(home!=null){
                        int number = home.getNumber();
                    }
                }
            }
        }

        int homeNumber = country2.getCity().getStreet().getHome().getNumber();
        System.out.println(homeNumber);


        Optional<Integer> homeNumber1 = Optional.ofNullable(country1)
                .map(Country::getCity)
                .map(City::getStreet)
                .map(Street::getHome)
                .map(Home::getNumber);

        Integer num = homeNumber1.orElse(22);
        System.out.println(num);
    }
}

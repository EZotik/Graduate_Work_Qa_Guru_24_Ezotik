package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;

public class RandomUtils {
    public Faker faker = new Faker();
    public String userName = faker.name().username();
    public String email = faker.internet().emailAddress(userName.toLowerCase() + 2000);
    public String password = faker.internet().password();
    public String firstName = faker.name().firstName();
    public String lastName = faker.elderScrolls().lastName();
    public String address = faker.address().fullAddress();
    public String city = getCity();
    public String state = getStateByCity(city);
    public String postcode = faker.address().zipCode();
    public String phoneNumber = faker.phoneNumber().subscriberNumber(10);

    String getCity() {
        return faker.options().option("Moscow", "Ulyanovsk", "Saransk", "Ryazan");
    }
    String getStateByCity(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("Moscow", "Moscow region");
        cityAndState.put("Ulyanovsk", "Ulyanovsk region");
        cityAndState.put("Saransk", "Saransk region");
        cityAndState.put("Ryazan", "Ryazan Oblast");
        return cityAndState.get(value);
    }
}

package utils;

import com.github.javafaker.Faker;

import java.util.HashMap;

public class RandomUserDataGenerator {
    public Faker faker = new Faker();
    public String userName = getUserName();
    public String email = faker.internet().emailAddress(userName.toLowerCase() + 2000);
    public String password = faker.internet().password();
    public String firstName = getFirstName();
    public String lastName = getLastName();
    public String address = getAddress();
    public String city = getCity();
    public String state = getStateByCity(city);
    public String postcode = faker.address().zipCode();
    public String phoneNumber = faker.phoneNumber().subscriberNumber(10);

    public String getUserName() {
        return faker.name().username();
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.elderScrolls().lastName();
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

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

package Com.nopcommerce.fakerdata;


import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class FakerData {
    private static FakerData fakerData;
    private Faker faker;  //object for faker API also
    private String password;


    public String getGender() {
        return faker.name().prefix();
    }

    public String getFirstname() {
        return faker.name().firstName();
    }

    public String getLastname() {
        return faker.name().lastName();
    }

    public String getDay() {
        return faker.date().birthday().toString();
    }

    public String getMonth() {
        return faker.date().birthday().toString();
    }

    public String getYear() {
        return faker.date().birthday().toString();
    }

    public String getCompany() {
        return faker.company().name();
    }

    public String getPassword() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        password=fakeValuesService.regexify("[0-9]{4}[A-Z]{2}[a-b]{4}");
        return password;
    }

    public String getCnfpassword() {
        return password;
    }

    public String getEmail() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        String email = fakeValuesService.bothify("????##@gmail.com");
        return email;
    }

    public String getAdrres1() {
        return faker.address().streetAddress(false);
    }

    public String getAdress2() {
        return faker.address().secondaryAddress();
    }

    public String getZip() {
        return faker.address().zipCode();
    }

    public String getState() {
        return faker.address().state();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getCountry() {
        return faker.address().country();
    }

    public String getPhonenumber() {
        return faker.phoneNumber().cellPhone();
    }

    private String city;
    private String country;
    private String phonenumber;

    private FakerData(){
        faker=new Faker();
    }
    public static FakerData getInstance(){
        if(fakerData==null)fakerData=new FakerData();
        return fakerData;
    }
}


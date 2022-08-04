import com.github.javafaker.Faker;

public class Praktikum {

    public static void main(String[] args) {
        Faker faker = new Faker();
        String ownerName = faker.name().fullName();

        Account account = new Account(ownerName);
        boolean result = account.checkNameToEmboss();
        System.out.println(result);
    }
}
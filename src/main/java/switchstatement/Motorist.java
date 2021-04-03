package switchstatement;

public class Motorist {

    private final String firstName;
    private final String surname;
    private final String title;
    private int age;
    private int insurancePoints;


    public Motorist(String title, String firstName, String surname, int age, int insurancePoints) {
        this.title = title;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.insurancePoints = insurancePoints;
    }

    public int getInsurancePoints() {
        return insurancePoints;
    }

    public int getAge() {
        return this.age;
    }
}
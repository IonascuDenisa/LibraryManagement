package Library;

public class Client extends Person{

    private int registrationNumber;

    private static int indexRegistration=0;

    public Client(String name, String phoneNumber, String address) {
        super(name, phoneNumber, address);
        indexRegistration++;
        this.registrationNumber=indexRegistration;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}

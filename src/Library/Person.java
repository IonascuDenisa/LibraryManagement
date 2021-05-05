package Library;



public abstract class Person {

    protected String name;
    protected String phoneNumber;
    protected String address;

    public Person(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    protected Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void print(){
        System.out.println("------------------------");
        System.out.println("Name is : " + name);
        System.out.println("Phone number is: " + phoneNumber);
        System.out.println("Address is : " + address);

    }
}

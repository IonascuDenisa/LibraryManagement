package Library;

import java.math.BigDecimal;

public class Librarian extends Employee{

    private int OfficeNumber;

    private static int indexOfficeNumber=0;

    public Librarian(String name, String phoneNumber, String address, BigDecimal salary) {
        super(name, phoneNumber, address, salary);
        indexOfficeNumber++;
        OfficeNumber = indexOfficeNumber;
    }

    public int getOfficeNumber() {
        return OfficeNumber;
    }

    @Override
    public void print(){
        super.print();
        System.out.println("Works at office number: " + OfficeNumber);
    }
}

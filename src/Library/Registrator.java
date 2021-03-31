package Library;

import java.math.BigDecimal;

public class Registrator extends Employee{

    private static int deskNumber;

    static int indexDesk=0;

    public Registrator(String name, String phoneNumber, String address, BigDecimal salary) {
        super(name, phoneNumber, address, salary);
        indexDesk++;
        this.deskNumber = indexDesk;
    }

    public int getDeskNumber() {
        return deskNumber;
    }

    @Override
    public void print(){
        super.print();
        System.out.println("Works at desk number: " + deskNumber);
    }
}

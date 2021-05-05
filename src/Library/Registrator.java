package Library;

import java.math.BigDecimal;

public class Registrator extends Employee{

    private int deskNumber;

    private static int indexDesk=0;

    public Registrator(){}
    public Registrator(String name, String phoneNumber, String address, BigDecimal salary) {
        super(name, phoneNumber, address, salary);
        indexDesk++;
        deskNumber = indexDesk;
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

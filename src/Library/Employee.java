package Library;

import java.math.BigDecimal;

public class Employee extends Person{

    protected int employeeID;
    protected BigDecimal salary;

    private static int indexID=0;

    public Employee(String name, String phoneNumber, String address, BigDecimal salary) {
        super(name, phoneNumber, address);
        indexID++;
        this.employeeID = indexID;
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public void print(){
        super.print();
        System.out.println("Id is: " + employeeID);
        System.out.println("Has this salary: " + salary);
    }


}


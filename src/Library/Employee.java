package Library;

import java.math.BigDecimal;
import java.util.List;

public class Employee extends Person implements SearchEmployee{

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

    public Employee(){}
    @Override
    public void print(){
        super.print();
        System.out.println("Id is: " + employeeID);
        System.out.println("Has this salary: " + salary);
    }


    @Override
    public Employee SearchId(List<Employee> e, int idToFind) {
        for(Employee emp:e)
        {
            if(emp.employeeID == idToFind)
                return emp;
        }
        return null;
    }

    @Override
    public Employee SearchByDesk(List<Employee> e, int desk) {
        for(Employee emp:e)
        {
            if(emp instanceof Registrator){
                Employee reg= new Registrator();
                reg=emp;
                Registrator plm=new Registrator();
                plm=(Registrator) reg;
                if(plm.getDeskNumber()==desk)
                    return  (Employee)plm;
            }
        }
        return null;

    }

    @Override
    public Employee SearchByOffice(List<Employee> e, int office) {
        for(Employee p:e)
        {
            if(p instanceof Librarian){
                Employee lib= new Librarian();
                lib=p;
                Librarian lib2=new Librarian();
                lib2=(Librarian) lib;
                if(lib2.getOfficeNumber()==office)
                    return  (Employee) lib2;
            }
        }
        return null;
    }
}
/*
    Employee e = new Employee();

    Employee reg = new Registrator("cara", "32021","unirii", BigDecimal.valueOf(2000));
    Registrator plm=new Registrator();

    plm=(Registrator)reg;*/

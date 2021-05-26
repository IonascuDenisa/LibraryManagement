package Library.BD;

import Library.Registrator;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistratorBD {
    Connection connection = SqlConfig.getDataBaseConnection();

    public void insertRegistrator(Registrator registrator) {
        String sql = "INSERT INTO Registrator(name,phoneNumber, address,salary) VALUES(?,?,?,?)";


        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, registrator.getName());
            statement.setString(2, registrator.getPhoneNumber());
            statement.setString(3, registrator.getAddress());
            statement.setString(4, String.valueOf(registrator.getSalary()));

            statement.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("Cannot insert into table");
        }
    }

    public void updateSalary(BigDecimal salary, int id) {
        String sql = "update Registrator set salary = ? where DeskNumber = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBigDecimal(1, salary);
            statement.setInt(2, id);

            statement.executeUpdate();
            System.out.println("Registrator with desk number "+ String.valueOf(id) + "now has the salary: " + String.valueOf(salary));
        } catch (SQLException exception) {
            System.err.println("Cannot update table");
        }
    }

    public void selectRegistrator(){
        String sql="Select * from Registrator";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("deskNumber"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("phoneNumber"));
                System.out.println(rs.getString("address"));
                System.out.println(rs.getBigDecimal("Salary"));
            }


        }catch (SQLException exception) {
            System.err.println("Cannot select from table");
        }
    }

}

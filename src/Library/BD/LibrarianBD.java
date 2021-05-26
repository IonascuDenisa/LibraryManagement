package Library.BD;

import Library.Librarian;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibrarianBD {
    Connection connection = SqlConfig.getDataBaseConnection();

    public void insertLibrarian(Librarian librarian) {
        String sql = "INSERT INTO Librarian(name,phoneNumber, address,salary) VALUES(?,?,?,?)";


        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, librarian.getName());
            statement.setString(2, librarian.getPhoneNumber());
            statement.setString(3, librarian.getAddress());
            statement.setString(4, String.valueOf(librarian.getSalary()));


            statement.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("Cannot insert into table");
        }
    }

    public void updateSalary(BigDecimal salary, int id) {
        String sql = "update Librarian set salary = ? where OfficeNumber = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBigDecimal(1, salary);
            statement.setInt(2, id);

            statement.executeUpdate();
            System.out.println("Librarian with office number "+ String.valueOf(id) + "now has the salary: " + String.valueOf(salary));
        } catch (SQLException exception) {
            System.err.println("Cannot update table");
        }
    }

    public void selectLibrarians(){
        String sql="Select * from librarian";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("officeNumber"));
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

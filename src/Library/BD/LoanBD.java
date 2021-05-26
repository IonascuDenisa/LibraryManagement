package Library.BD;

import Library.Loan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanBD {
    Connection connection = SqlConfig.getDataBaseConnection();

    public void insertLoan(Loan loan) {
        String sql = "INSERT INTO Loan(id_book,RegistrationNumber, OfficeNumber ) VALUES(?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, loan.getBook().getId());
            statement.setInt(2, loan.getClient().getRegistrationNumber());
            statement.setInt(3, loan.getLibrarian().getOfficeNumber());

            statement.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("Cannot insert into table");
        }
    }
    public void deleteLoan(int id_loan) {
        try{
                String sql = "delete from Loan where id_loan= ?";
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, id_loan);
                ps.executeUpdate();
                System.out.println("Loan deleted");

        } catch (SQLException exception) {
            System.err.println("Cannot delete from table loan");
        }
    }

    public void selectLoans(){

        try{
            String sql = "select l.id_loan, b.title, c.name, lib.name, b.id_book \n" +
                    "  from loan l join book b on l.id_book=b.id_book\n" +
                    "  join client c on l.registrationNumber= c.registrationNumber\n" +
                    "  join librarian lib on l.officeNumber=lib.officeNumber\n" +
                    "order by l.id_loan";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("b.title") +"was borrowed by "+ rs.getString("c.name")+". The loan was made by "+
                        rs.getString("lib.name"));
            }

        } catch (SQLException exception) {
            System.err.println("Cannot select from table loan");
        }


    }




}

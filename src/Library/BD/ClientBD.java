package Library.BD;

import Library.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientBD {
    Connection connection = SqlConfig.getDataBaseConnection();
    public void insertClient(Client client) {
        String sql = "INSERT INTO client(name,phoneNumber, address) VALUES(?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, client.getName());
            statement.setString(2, client.getPhoneNumber());
            statement.setString(3, client.getAddress());


            statement.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("Cannot insert into table");
        }
    }

    public void deleteOneclient(int regNo) {
        String sql = "delete from Client where registrationNumber= ?";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, regNo);
            ps.executeUpdate();
            System.out.println("Client deleted");

        } catch (SQLException exception) {
            System.err.println("Cannot delete from table Client");
        }
    }


    public void updateClientPhoneNo(int regNo,String PhNo){
        String sql = "update client set phoneNumber = ? where registrationNumber = ?";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, PhNo);
            ps.setInt(2,regNo);
            ps.executeUpdate();
            System.out.println("Client's Phone Number has been  updated to " + PhNo);

        }catch (SQLException exception) {
            System.err.println("Cannot update CLient's phone number");
        }

    }

    public void selectClients(){

        String sql = "select * from Client";


    }
}
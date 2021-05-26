package Library.BD;

import Library.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorBD {

    Connection connection = SqlConfig.getDataBaseConnection();

    public void insertAuthor(Author author) {
        String sql = "INSERT INTO Author(name,literaryMovement, birthYear, deathYear, isAlive) VALUES(?,?,?,?,?)";


        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, author.getName());
            statement.setString(2, author.getLiteraryMovement());
            statement.setInt(3, author.getBirthYear());
            statement.setInt(4, author.getDeathYear());
            if(author.getAlive() == null){
                statement.setBoolean(5, false );
            }else{
                statement.setBoolean(5,author.getAlive() );
            }




            statement.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("Cannot insert into table");
        }
    }


    public void updateDeathYear(int year, int id) {
        String sql = "update author set DeathYear = ? where id_Author =?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, year);
            statement.setInt(2, id);

            statement.executeUpdate();
            System.out.println("updated death of year to "+String.valueOf(year)+" for author with id" + String.valueOf(id));
        } catch (SQLException exception) {
            System.err.println("Cannot update Author's death year ");
        }
    }

    public void selectByName(String NameToFind) throws SQLException {
        String sql = "select * from author where lower(name) like ? ";

            PreparedStatement statement = connection.prepareStatement(sql);
            String str="%"+NameToFind+"%";
            statement.setString(1,str);
            Author a = new Author();
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                a.setId(rs.getInt("id_Author"));
                a.setName(rs.getString("name"));
                a.setLiteraryMovement(rs.getString("LiteraryMovement"));
                a.setBirthYear(rs.getInt("birthYear"));
                a.setDeathYear(rs.getInt("deathYear"));
                a.printAuthor();
            }
    }
    public void selectAllAuthors() throws SQLException {
        String sql = "select * from author ";

        PreparedStatement statement = connection.prepareStatement(sql);
        Author a = new Author();
        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            a.setId(rs.getInt("id_Author"));
            a.setName(rs.getString("name"));
            a.setLiteraryMovement(rs.getString("LiteraryMovement"));
            a.setBirthYear(rs.getInt("birthYear"));
            a.setDeathYear(rs.getInt("deathYear"));
            a.printAuthor();
        }
    }

}

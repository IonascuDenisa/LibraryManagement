package Library.BD;

import Library.Author;
import Library.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Auth_BooksBD {
    Connection connection = SqlConfig.getDataBaseConnection();
    public void insertAuth_Books(Book book, Author author){
        String sql = "INSERT INTO Auth_Books(id_book, id_author) VALUES(?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, book.getId());
            statement.setInt(2, author.getId());
            statement.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("Cannot insert into table Auth_bookBD");
        }

    }

}

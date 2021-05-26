package Library.BD;

import Library.Author;
import Library.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookBD {
    Connection connection = SqlConfig.getDataBaseConnection();

    public void insertBook(Book book) {
        String sql = "INSERT INTO Book(numberOfCopiesAvailable, title,category, pageNo,digitalAvailable, deskNumber) VALUES(?,?,?,?,?,?)";


        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(book.getNumberOfCopiesAvailable()));
            statement.setString(2, book.getTitle());
            statement.setString(3,book.getCategory());
            statement.setInt(4,book.getPageNo());
            statement.setBoolean(5, book.isDigitalAvailable());
            statement.setInt(6,book.getRegistratorDeskNumber());

            statement.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("Cannot insert into table Book");
        }
    }

    public void updateDeskNo(int desk, int id){
        String sql = "update books set deskNumber = ? where id_book = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,desk);
            statement.setInt(2,id);

            statement.executeUpdate();
            System.out.println("updated desk");
        }catch (SQLException exception) {
            System.err.println("Cannot update Book's desk");
        }
    }

    public void selectDigitalBooks()throws SQLException {
        String sql = "select b.title, a.name from book b, auth_books ab, Author a where digitalAvailable = 1 and b.id_book=ab.id_book and ab.id_Author=a.id_Author";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("title") +" by "+ rs.getString("name"));
        }
    }

    public void selectAliveAuthorBooks()throws SQLException {
        String sql = "select b.title, a.name from book b, auth_books ab, Author a where isAlive = 1 and b.id_book=ab.id_book and ab.id_Author=a.id_Author";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("title") +" by "+ rs.getString("name"));
        }
    }

    public void selectBooksAvForLoaning()throws SQLException {
        String sql = "select b.title, a.name from book b, auth_books ab, Author a where numberOfCopiesAvailable > 0 and b.id_book=ab.id_book and ab.id_Author=a.id_Author";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("title") +" by "+ rs.getString("name"));
        }
    }

    public void selectAll() throws SQLException {
        String sql = "select distinct numberOfCopiesAvailable, title, category, pageNo, digitalAvailable, deskNumber, name , literaryMovement " +
                     "from book b , Auth_Books ab, Author a where b.id_book=ab.id_book and ab.id_Author=a.id_Author";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("title"));
            System.out.println("category: " + rs.getString("category"));
            System.out.println("Number of pages: " + rs.getInt("PageNo"));
            System.out.println("Is digital Available: " + rs.getBoolean("digitalAvailable"));
            System.out.println("Written by: " + rs.getString("name"));
            System.out.println("Literary movement: " + rs.getString("literaryMovement"));
        }
    }

    public void selectBooksMovement(String move)throws SQLException {
        String sql = "select b.title, a.name from book b, auth_books ab, Author a where lower(literaryMovement) like ? and b.id_book=ab.id_book and ab.id_Author=a.id_Author";

        PreparedStatement statement = connection.prepareStatement(sql);
        String str="%"+move+"%";
        statement.setString(1,str.toLowerCase());
        Author a = new Author();
        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("title") +" by "+ rs.getString("name"));
        }
    }

    public void orderByTitle() throws SQLException {
        String sql = "select b.title, a.name from book b, auth_books ab, Author a where b.id_book=ab.id_book and ab.id_Author=a.id_Author order by title";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("title") +" by "+ rs.getString("name"));
        }


    }

    public void orderByAuthor() throws SQLException {
        String sql = "select b.title, a.name from book b, auth_books ab, Author a where b.id_book=ab.id_book and ab.id_Author=a.id_Author order by name";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("title") +" by "+ rs.getString("name"));
        }


    }

    public void orderByMovement() throws SQLException {
        String sql = "select b.title, a.name, a.literaryMovement from book b, auth_books ab, Author a where b.id_book=ab.id_book and ab.id_Author=a.id_Author order by a.literaryMovement";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("literaryMovement") +" : "+ rs.getString( "title") +" by "+ rs.getString("name"));
        }

    }

    public void orderByPages() throws SQLException {
        String sql = "select b.title, a.name , b.pageNo from book b, auth_books ab, Author a where b.id_book=ab.id_book and ab.id_Author=a.id_Author order by pageNo";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString( "title") +" by "+ rs.getString("name") +"has "+ rs.getInt("pageNo"));
        }

    }

}

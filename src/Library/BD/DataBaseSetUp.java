package Library.BD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseSetUp {

    Connection dataBaseConnection = SqlConfig.getDataBaseConnection();

    public void deleteClientTable(){
        String sql = "DROP TABLE Client";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(sql);
        } catch (SQLException exception) {
            System.err.println("Could not delete table Client");
        }

    }
    public void deleteLibrarianTable(){
        String sql = "DROP TABLE Librarian";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(sql);
        } catch (SQLException exception) {
            System.err.println("Could not delete table Librarian");
        }

    }
    public void deleteRegistratorTable(){
        String sql = "DROP TABLE Registrator";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(sql);
        } catch (SQLException exception) {
            System.err.println("Could not delete table Registrator");
        }

    }
    public void deleteAuthorTable(){
        String sql = "DROP TABLE Author";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(sql);
        } catch (SQLException exception) {
            System.err.println("Could not delete table Author");
        }

    }

    public void deleteBookTable(){
        String sql = "DROP TABLE Book";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(sql);
        } catch (SQLException exception) {
            System.err.println("Could not delete table Book");
        }

    }
    public void deleteAuth_BookTable(){
        String sql = "DROP TABLE Auth_Books";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(sql);
        } catch (SQLException exception) {
            System.err.println("Could not delete table Auth_Books");
        }

    }

    public void deleteLoanTable(){
        String sql = "DROP TABLE loan";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(sql);
        } catch (SQLException exception) {
            System.err.println("Could not delete table Loan");
        }

    }

    public void setUpClient() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS client (RegistrationNumber int PRIMARY KEY AUTO_INCREMENT," +
                                                    " name varchar(40), phoneNumber varchar(10) , address varchar(50))";
        Connection dataBaseConnection = SqlConfig.getDataBaseConnection();
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException exception) {
            System.err.println("Could not create table");
        }
    }

    public void setUpRegistator() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Registrator(deskNumber int PRIMARY KEY auto_increment, name varchar(40), " +
                                                    " phoneNumber varchar(10) , address varchar(50), Salary decimal)";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException exception) {
            System.err.println("Could not create table");
        }
    }

    public void setUpLibrarian() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Librarian(OfficeNumber int PRIMARY KEY auto_increment, name varchar(40)," +
                "                         phoneNumber varchar(10) , address varchar(50), Salary decimal)";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException exception) {
            System.err.println("Could not create table");
        }
    }

    public void setUpAuthor() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Author(id_Author int PRIMARY KEY AUTO_INCREMENT, name varchar(40)," +
                                         "literaryMovement varchar(50), birthYear int, deathYear int, isAlive boolean)";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException exception) {
            System.err.println("Could not create table");
        }
    }


    public void setUpBook() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Book(id_book int PRIMARY KEY AUTO_INCREMENT, numberOfCopiesAvailable int, title varchar(60), category varchar(40)," +
                "pageNo int, digitalAvailable boolean, deskNumber int,\n" +
                "FOREIGN KEY ( deskNumber)    REFERENCES Registrator (deskNumber) ON DELETE CASCADE)";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException exception) {
            System.err.println("Could not create table");
        }
    }

    public void setUpAuth_Book() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Auth_Books(id_AthB int PRIMARY KEY AUTO_INCREMENT,id_book int,id_author int," +
                                                "FOREIGN KEY(id_book) REFERENCES  Book(id_book)ON DELETE CASCADE, " +
                                                "FOREIGN KEY(id_author) REFERENCES Author(id_Author) ON DELETE CASCADE)";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException exception) {
            System.err.println("Could not create table");
        }
    }

    public void setUpLoan() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Loan(id_loan int PRIMARY KEY AUTO_INCREMENT, id_book int, RegistrationNumber int, OfficeNumber int," +
                                    "FOREIGN KEY(id_book) REFERENCES  Book(id_book) ON DELETE CASCADE, " +
                                    "FOREIGN KEY(RegistrationNumber) REFERENCES Client(RegistrationNumber)ON DELETE CASCADE," +
                                    "FOREIGN KEY(OfficeNumber) REFERENCES Librarian(OfficeNumber) ON DELETE CASCADE)";
        try {
            Statement statement = dataBaseConnection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException exception) {
            System.err.println("Could not create table");
        }
    }

    public void setUp(){
        deleteLoanTable();
        deleteClientTable();
        deleteLibrarianTable();
        deleteAuth_BookTable();
        deleteBookTable();
        deleteAuthorTable();
        deleteRegistratorTable();
        setUpClient();
        setUpLibrarian();
        setUpRegistator();
        setUpBook();
        setUpAuthor();
        setUpAuth_Book();
        setUpLoan();
    }

}

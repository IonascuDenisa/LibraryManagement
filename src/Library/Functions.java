package Library;

import Library.BD.*;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Functions{
    ClientBD cl = new ClientBD();
    Auth_BooksBD ab= new Auth_BooksBD();
    LibrarianBD l=new LibrarianBD();
    RegistratorBD r=new RegistratorBD();
    BookBD b=new BookBD();
    AuthorBD a= new AuthorBD();
    LoanBD lo = new LoanBD();

    public void AddClientBD(Client client) throws SQLException{
        cl.insertClient(client);
    }
    public void deleteOneClient(int regNr){
        cl.deleteOneclient(regNr);
    }
    public void updateClientPhone(int regNo, String Ph)throws SQLException{
        cl.updateClientPhoneNo(regNo,Ph);
    }
    public void selectClient(){cl.selectClients();}
    public void AddLibrarianBD(Librarian librarian) throws SQLException {

        l.insertLibrarian(librarian);
    }
    public void updateLibrarianSalary(BigDecimal sal, int id){
        l.updateSalary(sal,id);
    }
    public void selectAllLibrarians(){l.selectLibrarians();}
    public void AddRegistratorBD(Registrator registrator) throws SQLException {
        r.insertRegistrator(registrator);
    }
    public void selectAllRegistrators(){r.selectRegistrator();}
    public void updateRegistrator(BigDecimal sal,int id){r.updateSalary(sal,id);}
    public void AddBooksBD(Book book) throws SQLException{
        b.insertBook(book);
    }
    public void updateBookDeskNo(int desk, int id){
        b.updateDeskNo(desk,id);
    }
    public void selectDigitalBooks() throws SQLException {
        b.selectDigitalBooks();
    }
    public void selectAliveAuthorBooks() throws SQLException {
        b.selectAliveAuthorBooks();
    }

    public void selectBooksAvForLoaning() throws SQLException {
        b.selectBooksAvForLoaning();
    }
    public void selectAllBooks() throws SQLException {
        b.selectAll();
    }
    public void selectBooksByMove(String move) throws SQLException {
        b.selectBooksMovement(move);
    }
    public void orderBookTitle() throws SQLException {b.orderByTitle();}

    public void orderBookAuthor() throws SQLException {b.orderByAuthor();}

    public void orderBookMove() throws SQLException {b.orderByMovement();}

    public void orderBookPages() throws SQLException {b.orderByPages();}

    public void AddAuthorBD(Author author) throws SQLException{
        a.insertAuthor(author);
    }
    public void updateDeathAuthor(int year, int id){
        a.updateDeathYear(year, id);
    }
    public void selectAuthorByName(String name) throws SQLException {
        a.selectByName(name);
    }
    public void selectAllAuthors() throws SQLException {
        a.selectAllAuthors();
    }
    public void AddAuth_bookBD(Book book,Author author) throws SQLException{
        ab.insertAuth_Books(book,author);

    }
    public void AddLoanBD(Loan loan)throws SQLException{
        lo.insertLoan(loan);
    }
    public void deleteLoan(int id){
        lo.deleteLoan(id);
    }
    public void selectLoans(){lo.selectLoans();}




}

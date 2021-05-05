package Library;

import java.util.Date;

public class Loan {

    private Book book;
    private Client client;
    private Librarian librarian;
   /* private Date date;
    private Date dueDate;*/

    public Loan(Book book, Client client, Librarian librarian/*, Date date, Date dueDate*/) {
        this.book = book;
        this.client = client;
        this.librarian = librarian;
       /* this.date = date;
        this.dueDate = dueDate;*/
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public void SetAvailability(){

        book.setNumberOfCopiesAvailable(book.getNumberOfCopiesAvailable()-1);
    }

    public void print(){
        System.out.println("Cartea imprumutata este:");book.shortPrint();
        System.out.println("Imprumutata de:"+ client.getName());
        System.out.println("Imprumut realizat de:" + librarian.getName());

    }
}

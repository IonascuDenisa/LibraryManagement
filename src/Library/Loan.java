package Library;

public class Loan {

    private Book book;
    private Client client;
    private Librarian librarian;

    public Loan(Book book, Client client, Librarian librarian) {
        this.book = book;
        this.client = client;
        this.librarian = librarian;
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
}

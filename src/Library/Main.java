// TODO Loan.DueDate
// TODO phoneNumbers from csv

package Library;

import Library.BD.DataBaseSetUp;
import Library.BD.SqlConfig;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws IOException, SQLException {

        Read r;
        r= Read.getInstance();

        List<Employee> employees = new ArrayList<>();
        employees = r.readEmployees();

        List<Registrator> reg = new ArrayList<>();
        reg.add((Registrator) employees.get(2));
        reg.add((Registrator) employees.get(3));

        List<Librarian> lib = new ArrayList<>();
        lib.add((Librarian) employees.get(0));
        lib.add((Librarian) employees.get(1));

        List<Author> authors =  new ArrayList<>();

        authors= r.readAuthors();

        List<Book> books =  new ArrayList<>();
        books = r.readBooks(authors,employees);

        List<Client> clients= new ArrayList<>();
        clients=r.readClients();

        List<Loan> loans= new ArrayList<>();
        loans=r.readLoan(books,clients,employees);
        /*for(Loan index: loans)
        {
            index.print();
        }*/

        //System.out.println("       ** Welcome to our library! **          ");

        List<Book> DigitBooks = new ArrayList<>();
        DigitBooks=Utillity.DigitalAvailable(books);

        Connection dataBaseConnection = SqlConfig.getDataBaseConnection();
       DataBaseSetUp set = new DataBaseSetUp();
       set.setUp();
        Functions f = new Functions();


        for(Client c: clients){
            f.AddClientBD(c);
        }
        for(Librarian l: lib){
            f.AddLibrarianBD(l);
        }
        for(Registrator regi:reg){
            f.AddRegistratorBD(regi);
        }
        for(Book b: books) {
            f.AddBooksBD(b);
        }
        for(Author au: authors) {
            f.AddAuthorBD(au);
        }
        f.AddAuth_bookBD(books.get(0), authors.get(0));
        f.AddAuth_bookBD(books.get(1), authors.get(0));
        f.AddAuth_bookBD(books.get(2), authors.get(1));
        f.AddAuth_bookBD(books.get(2), authors.get(2));
        f.AddAuth_bookBD(books.get(3), authors.get(3));
        f.AddAuth_bookBD(books.get(4), authors.get(4));

        for(Loan l: loans){
            f.AddLoanBD(l);
        }
        //f.deleteLoan(4);
        //f.deleteOneClient(1);
       // f.updateClientPhone(2,"074444");


        menu m= new menu();

/*












        System.out.println("press '0' if you want to exit ");


        System.out.println("Type '5' to print clients");
       Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));
        int choice=0;
        choice= scanner.nextInt();
        Write w;
        w=Write.getInstance();
        if(choice==1)
        {
            clients=w.addClient(clients);
        }
        if(choice==2){
            books=w.addBook(authors,books,employees); // also adds new author
        }
        if(choice==3){
            loans=w.addLoan(clients,books,employees,loans);
        }
        if(choice ==4) {
            System.out.print("Type name of the author...");
            String namee= scanner.next();
            f.selectAuthorByName(namee);
        }
        if(choice == 5){
            for(Client c : clients){
                c.print();
            }
        }
        audit a=new audit(choice);
*/
        SqlConfig.closeDataBaseConnection();
    }
}
/*  Employee e = new Employee();
    e=e.SearchByDesk(employees,2);
    System.out.println("+++"+e.getName()+"+++");

    Utillity.PrintCur(books, "Romantic"); //Cautare carte dupa curent literar

    Utillity.SortByPage(books);

     Print books sorted by number of pages: Utillity.SortByPage(books);
     authors.get(1).AlphabeticalSort(null,authors,1);
     books.get(1).AlphabeticalSort(books,null,1);

 */
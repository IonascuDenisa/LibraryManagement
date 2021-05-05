// TODO Loan.DueDate
// TODO phoneNumbers from csv

package Library;

import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws IOException {
        Read r;
        r= Read.getInstance();

        List<Employee> employees = new ArrayList<>();
        employees = r.readEmployees();



        List<Author> authors =  new ArrayList<>();

        authors= r.readAuthors();

        List<Book> books =  new ArrayList<>();
        books = r.readBooks(authors,employees);

        List<Client> clients= new ArrayList<>();
        clients=r.readClients();

        List<Loan> loans= new ArrayList<>();
        loans=r.readLoan(books,clients,employees);
        System.out.println("nu merge");
        for(Loan index: loans)
        {
            index.print();
        }

        //System.out.println("       ** Welcome to our library! **          ");

        List<Book> DigitBooks = new ArrayList<>();
        DigitBooks=Utillity.DigitalAvailable(books);

        System.out.println("Type '1' to add new client");
        System.out.println("Type '2' to add a new book");
        System.out.println("Type '3' to add a new loan");
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
        audit a=new audit(choice);


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
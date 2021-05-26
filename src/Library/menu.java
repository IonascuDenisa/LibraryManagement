package Library;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class menu {
    Functions f = new Functions();

    public void DisplayOptions(){
        System.out.println("Type '1' if you want to display informations about our our books"); // are part 2 + all books
        System.out.println("Type '2' if you want to display informations about our authors"); // are part 2 + all authors
        System.out.println("Type '3' if you want to display informations about our employees"); // part 2
        System.out.println("Type '4' if you want to display informations about our clients");
        System.out.println("Type '5' if you want to display informations about our loans");
        System.out.println("Type '6' to add new client");
        System.out.println("Type '7' to add a new author");
        System.out.println("Type '8' to add a new book");
        System.out.println("Type '9' to add a new loan");
        System.out.println("Type '25' if you want to change a client's phone number");
        System.out.println("Type '26' if you want to update an author's year of death ");
        System.out.println("Type '27' if you want to update the salary of a librarian");
        System.out.println("Type '28' if you want to update the salary of a registrator");


    }

    public void handleCommands(int choice) throws SQLException {

            switch (choice){
                case 1:
                    handleBookChoice();
                    break;
                case 2:
                    HandleAuthorChoice();
                    break;
                case 3:
                    HandleEmployees();
                    break;
                case 4:
                    f.selectClient();
                    break;
                case 5:
                    f.selectLoans();
                    break;
                case 6:
                    System.out.println("This functionality is not yet implemented");
                    break;
                case 7:
                    System.out.println("This functionality is not yet implemented");
                    break;
                case 8:
                    System.out.println("This functionality is not yet implemented");
                    break;
                case 9:
                    System.out.println("This functionality is not yet implemented");
                    break;
                case 10:
                    f.selectBooksAvForLoaning();
                    break;
                case 11:
                    f.selectDigitalBooks();
                    break;
                case 12:
                    f.selectAliveAuthorBooks();
                    break;
                case 13:
                    handleBookChoice13();
                    break;
                case 14:
                    handleBookChoice14();
                    break;
                case 15:
                    f.selectAllBooks();
                    break;
                case 16:
                    f.orderBookTitle();
                    break;
                case 17:
                    f.orderBookAuthor();
                    break;
                case 18:
                    f.orderBookMove();
                    break;
                case 19:
                    f.orderBookPages();
                    break;
                case 20:
                    f.selectAllAuthors();
                    break;
                case 21:
                    HandleChoice21();
                    break;
                case 22:
                    f.selectAllLibrarians();
                    f.selectAllRegistrators();
                    break;
                case 23:
                    f.selectAllLibrarians();
                    break;
                case 24:
                    f.selectAllRegistrators();
                    break;
                case 25:
                    HandleClientUpdate();
                    break;
                case 26:
                    HandleAuthorUpdate();
                    break;
                case 27:
                    handleLibrarianUpdate();
                    break;
                case 28:
                    handleRegistratorUpdate();
                    break;
            }

        }


    public void handleAll() throws SQLException {
        Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));
        int choice=333;

        while(choice != 0){
            choice= scanner.nextInt();
            handleCommands(choice);
        }

    }

    public void handleBookChoice(){
        System.out.println("Type '10'  if you want to display books that are available for loaning");
        System.out.println("Type '11'  if you want to display our digital books");
        System.out.println("Type '12'  if you want to display books written by contemporary authors");
        System.out.println("Type '13'  if you want to display books that belog to a specific lirerary movement");
        System.out.println("Type '14'  if you want to display our books sorted");
        System.out.println("Type '15'  if you want to display all the books from our library");
    }
    public void handleBookChoice13() throws SQLException {
        System.out.println("Type literary Movement:");
        Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));
        String move= scanner.next();
        scanner.nextLine();
        f.selectBooksByMove(move);

    }
    public void handleBookChoice14() throws SQLException {
        System.out.println("Sort books by:   16.Title  17.Author's name   18.Literary Movement    19.Number of pages");
        Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));
        int choice = scanner.nextInt();
        handleCommands(choice);

    }
    public void HandleAuthorChoice() throws SQLException {
        System.out.println("Type '20' if you want to display all authors");
        System.out.println("Type '21' if you want to search authors by name");
        Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));
        int choice = scanner.nextInt();
        handleCommands(choice);

    }
    public void HandleChoice21() throws SQLException {

        System.out.println("Type name you:");
        Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));
        String name= scanner.next();
        scanner.nextLine();
        f.selectAuthorByName(name);
    }
    public void HandleEmployees() throws SQLException {
        System.out.println(" Choose: 22.All employees    23.Librarians      24.Registrators");
        Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));
        int choice = scanner.nextInt();
        handleCommands(choice);

    }
    public void HandleClientUpdate() throws SQLException {
        System.out.println("Type the registration number of the client...");
        Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));
        int regNo= scanner.nextInt();
        System.out.println("Type the new phone number... ");
        String phone = scanner.next();
        scanner.nextLine();
        f.updateClientPhone(regNo,phone);

    }

    public void HandleAuthorUpdate() throws SQLException {
        System.out.println("Type the id of the author... ");
        Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));
        int id= scanner.nextInt();
        System.out.println("Type the new year of death... ");
        int year = scanner.nextInt();
        f.updateDeathAuthor(id,year);
   }
   public void handleLibrarianUpdate(){
       System.out.println("Type the librarian's office number...");
       Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));
       int id= scanner.nextInt();
       System.out.println("Type the librarian's new salary...");
       BigDecimal sal = scanner.nextBigDecimal();
       f.updateLibrarianSalary(sal,id);
   }

    public void handleRegistratorUpdate(){
        System.out.println("Type the registrator's desk number...");
        Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));
        int id= scanner.nextInt();
        System.out.println("Type the registrator's new salary...");
        BigDecimal sal = scanner.nextBigDecimal();
        f.updateRegistrator(sal,id);
    }


    menu() throws SQLException {
        DisplayOptions();
        handleAll();
    }
}

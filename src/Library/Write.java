package Library;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

public class Write { //write to file

    Functions f = new Functions();

    private static Write w = null;

    private Write(){}

    public static Write getInstance(){
        if(w ==null){
            w= new Write();
        }
        return w;
    }

    public List<Client> addClient(List<Client> c) throws IOException, SQLException {

        String path = "D:\\LABORATOARE EAP\\Library\\Clients.csv";
        FileWriter writer=new FileWriter(path,true);
        BufferedWriter bw = new BufferedWriter(writer);
        PrintWriter pw = new PrintWriter(bw);

        Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));

        System.out.println("Type informations for new client");
        System.out.print("Name: ");
        String name=scanner.next();
        scanner.next();

        System.out.print("Phone number: ");
        String phone=scanner.next();
        System.out.print("Address: ");
        String address=scanner.nextLine();

        System.out.println(name+"  "+ phone +" "+ address);
        String comma=",";
        String row;
        row = name+comma+phone+comma+address;

        pw.flush();
        pw.close();
        Client client = new Client(name, phone, address);
        c.add(client);
        return c;
    }
    public List<Book> addBook(List<Author> authors,List<Book> books, List<Employee> e){ // + new author
        String pathBooks = "D:\\LABORATOARE EAP\\Library\\books.csv";
        String pathAuthors = "D:\\LABORATOARE EAP\\Library\\authors.csv";
        try {
            FileWriter writerAuthor = new FileWriter(pathAuthors, true);
            BufferedWriter bwA = new BufferedWriter(writerAuthor);
            PrintWriter pwA = new PrintWriter(bwA);

            FileWriter writerBooks = new FileWriter(pathBooks, true);
            BufferedWriter bwB = new BufferedWriter(writerBooks);
            PrintWriter pwB = new PrintWriter(bwB);

            Scanner scanner = new Scanner(System.in).useDelimiter(Pattern.compile("[\\n]"));
            String choice;
            System.out.println("Is the author already in out database? Type yes or no");
            choice=scanner.next();
            int number = 0; // the positon of the author of the book
            Author a = new Author();
            String row;
            if(choice.toLowerCase().equals("no")){
                a=readA();
                authors.add(a);
                number=authors.size();
                row=a.getName()+","+a.getLiteraryMovement() +"," +String.valueOf(a.getBirthYear())+","+String.valueOf(a.getDeathYear());
                pwA.println(row);
                pwA.flush();
                pwA.close();
            }
            else if(choice.toLowerCase().equals("yes")){
                System.out.println("What is the number of the autor?");
                number=scanner.nextInt();
            }
            else{
                System.out.println("Invalid choice");
                System.exit(-1);
            }

            System.out.println("What is the desk number of the registator that will take care of the book?");
            int deskno= scanner.nextInt();
            Employee employee = new Registrator();
            Registrator r= new Registrator();
            employee = employee.SearchByDesk(e, deskno);

            System.out.println("Type the number of copies: ");
            int copies=scanner.nextInt();
            scanner.nextLine();

            System.out.println("Type the title of the book:");
            String title=scanner.nextLine();

            System.out.println("What tipe of book is it? Type category:");
            String category=scanner.next();
            System.out.println("How many pages does the book have?");
            int pages=scanner.nextInt();

            System.out.println("Will there be a digital verion? Type true or false");
            String digital=scanner.next();

            Book newBook=new Book(copies,title,category,pages,Boolean.parseBoolean(digital),authors.subList(number-1,number),(Registrator)employee);
            books.add(newBook);

            row=String.valueOf(copies)+","+title+","+category+","+String.valueOf(pages)+","+digital+","+String.valueOf(number)+","+String.valueOf(deskno);
            pwB.println(row);
            pwB.flush();
            pwB.close();

        } catch (IOException ex){
            ex.printStackTrace();
        }
        return books;

    }
    public Author readA(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type informations about the author");

        System.out.println("Name: ");
        String name=scanner.nextLine();

        System.out.println("What literary movemement does he/she belong to?");
        String litmove = scanner.next();

        System.out.println("What year was he/she born in? If you do not know the answer type 0 ");
        int birthYear= scanner.nextInt();

        System.out.println("What year did he/she die in? If you do not know the answer type 0 ");
        int deathYear=scanner.nextInt();

        Author author=new Author(name,litmove,birthYear,deathYear);
        return author;

    }

    public List<Loan> addLoan(List<Client> c, List<Book>b, List<Employee> e, List<Loan> loan){

        String path = "D:\\LABORATOARE EAP\\Library\\Loan.csv";
        Scanner scanner = new Scanner(System.in);
        Book borrowedBook=new Book();
        Client cl = new Client();
        Librarian l=new Librarian();

        try{
            FileWriter writer=new FileWriter(path,true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter pw = new PrintWriter(bw);

            System.out.println("What is the id of the book that is borrowed?");
            int book=scanner.nextInt();
            if(book<b.size()){
                for(Book buk:b){
                    if(buk.getId()==book)
                    {
                        borrowedBook=buk;
                        if(borrowedBook.isAvailable()==false)
                        {
                            System.out.println("This book is not available for borrowing");
                            System.exit(-1);
                        }
                        break;
                    }
                }
            }
            else{
                System.out.println("The ID you typed is too big");
            }

            System.out.println("What is the registration number of the client?");
            int regNo=scanner.nextInt();
            if(regNo<=c.size()){
                cl=c.get(regNo-1);
            }
            else{
                System.out.println("The registration number you typed is too big");
            }

            System.out.println("What is the office number of the librarian that borrowed the book?");
            int office=scanner.nextInt();
            Employee em = new Librarian();
            if(em.SearchByOffice(e,office)==null)
            {
                System.out.println("The office number you typed does not exist");
                System.exit(-2);
            }
            em=em.SearchByOffice(e,office);

            String row;
            row = String.valueOf(book)+","+String.valueOf(regNo)+","+String.valueOf(office);
            pw.println(row);
            pw.flush();
            pw.close();

            Loan newLoan=new Loan(borrowedBook,cl,(Librarian)em);
            newLoan.SetAvailability();
            loan.add(newLoan);

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return loan;
    }

}

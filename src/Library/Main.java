// info about books
// info about authors
// info about authors and their books
// info about all tipes of employees
// info about each tipe of employee
// info about cliens
// info about loans

// the books that are available
// the books written by contemporary authors
// the books from one specific literar movement, or all books alphabetically ordered by literar movement
// the books written by one specific author, or all books orderd by author
// digital books
// books orderd by title or search book by title
// add new book
// add new loan
// add employee

package Library;

import java.math.BigDecimal;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        Employee lib1 = new Librarian("ana", "32021","unirii", BigDecimal.valueOf(23663));
        Employee lib2 = new Librarian("mara", "32021","unirii", BigDecimal.valueOf(2300939));
        Employee r3 = new Registrator("cara", "32021","unirii", BigDecimal.valueOf(230053));
        Employee r4 =  new Registrator("para", "32021","unirii", BigDecimal.valueOf(2345377));

        List<Employee> employees = new ArrayList<>();
        //List<Registrator> registrators = new ArrayList<>();

        employees.add(lib1);
        employees.add(lib2);
        employees.add(r3);
        employees.add(r4);

        for (Employee employee : employees) {
           // employee.print();
        }

        Book book1=new Book(3,"Poeme","poezii",500,false);
        Book book2=new Book(2,"Sarmanul Dionis","nuvela",200,true);


        Book book3=new Book(1,"Abecedar","manual scolar",160,false);

        List<Author> authors = new ArrayList<>();

        List <Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);



        Author author1= new Author("Mihai Eminescu","Romantic",1850,1889, books.subList(0,2));
        Author author2=new Author("Cleopatra Mihailescu",null,0,0,books.subList(2,3));
        Author author3=new Author("Tudora Pitila",null, 0,0,books.subList(2,3));

        authors.add(author1);
        authors.add(author2);
        authors.add(author3);

        for(Author a: authors) {
            a.printbook();
        }

  }
}

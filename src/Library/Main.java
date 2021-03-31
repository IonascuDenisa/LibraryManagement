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
//

package Library;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        Employee lib1 = new Librarian("ana", "32021","unirii", BigDecimal.valueOf(23663));
        Employee lib2 = new Librarian("mara", "32021","unirii", BigDecimal.valueOf(230033));
        Employee r3 = new Registrator("cara", "32021","unirii", BigDecimal.valueOf(23453));
        Employee r4 =  new Registrator("cara", "32021","unirii", BigDecimal.valueOf(23453));

        List<Employee> employees = new ArrayList<>();
        //List<Registrator> registrators = new ArrayList<>();

        employees.add(lib1);
        employees.add(lib2);
        employees.add(r3);
        employees.add(r4);

        Iterator<Employee> l =employees.iterator();

        while(l.hasNext()) {
           l.next().print();
        }





    }
}

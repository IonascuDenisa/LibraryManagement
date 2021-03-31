package Library;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.sort;

public class Utility {
    private Utility(){}
    public static List<Book> SortByPage(List<Book> books){
        Book[] bl = new Book[books.size()];
        bl=books.toArray(bl);
        Arrays.sort(bl,new SortBookByPagesNo());
        books= Arrays.asList(bl.clone());

        for(Book a: books) {
            System.out.println(a.getTitle());
        }

        return books;
    }


}

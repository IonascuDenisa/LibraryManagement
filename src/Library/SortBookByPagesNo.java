package Library;

import java.util.Comparator;

public class SortBookByPagesNo implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPageNo()- o2.getPageNo();
    }
}

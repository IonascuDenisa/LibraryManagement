package Library;

import java.util.List;

public interface SearchBook {
    public List<Book> SearchTitle( List<Book> b, String title);
    public List<Book> SearchAuthor(List<Book> b, String authorName);
    public List<Book> SearchLitMove( List<Book> b, String LiteraryMove);
}

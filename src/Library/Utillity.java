package Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.sort;

public class Utillity {
    private Utillity(){}
    public static List<Book> SortByPage(List<Book> books){
        Book[] bl = new Book[books.size()];
        bl=books.toArray(bl);
        Arrays.sort(bl,new SortBookByPagesNo());
        books= Arrays.asList(bl.clone());
        return books;
    }

    public static List<Book> DigitalAvailable(List<Book> books){
        List<Book> digitalBooks=new ArrayList<>();
        for(Book buc:books)
        {
            if(buc.isDigitalAvailable())
                digitalBooks.add(buc);
        }
        return digitalBooks;
    }

    public static void PrintMove(List<Book> b,String MoveToFind){
        List<Book> found=new ArrayList<>();
        found = b.get(0).SearchLitMove(b,MoveToFind);
        for(Book index: found){
            index.print();
        }
    }
    public List<Book> GetAvailableBooks(List<Book>b)
    {
        List<Book> avBooks=new ArrayList<>();
        for(Book buc:b)
        {
            if(buc.getNumberOfCopiesAvailable()>0)
                avBooks.add(buc);
        }
        return avBooks;
    }

    public void PrintAvailableBooks(List<Book>b){
        List<Book> toPrint= new ArrayList<>();
        toPrint=GetAvailableBooks(b);
        for(Book buc: toPrint) {
            buc.print();
        }

    }
    }











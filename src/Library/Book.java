package Library;

import java.security.PublicKey;
import java.util.*;

public class Book implements Sort, SearchBook{

    private int id;
    private int numberOfCopiesAvailable;
    private String title;
    private String category;
    private int pageNo;
    private boolean digitalAvailable;
    private List<Author> authors;
    private Registrator PersonResponsable;

    private static int indexId=0;


        public Book (){}
        public Book(int numberOfCopies, String title, String category, int pageNo, boolean digitalAvailable, List<Author> authors, Registrator PersonResponsable) {
        this.numberOfCopiesAvailable =numberOfCopies;
        this.title = title;
        this.category = category;
        this.pageNo = pageNo;
        this.digitalAvailable = digitalAvailable;
        this.authors = authors;
        indexId++;
        this.id=indexId;
        this.PersonResponsable=PersonResponsable;

        }

    public List<Author> getAuthors() {
        return authors;
    }
    public Author getFirstAuthor(){
            return authors.get(0);
    }

    public Registrator getPersonResponsable() {
        return PersonResponsable;
    }
    public int getRegistratorDeskNumber() { return PersonResponsable.getDeskNumber();}

    public void setPersonResponsable(Registrator personResponsable) {
        PersonResponsable = personResponsable;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getNumberOfCopiesAvailable() {
        return numberOfCopiesAvailable;
    }

    public void setNumberOfCopiesAvailable(int numberOfCopiesAvailable) {
        this.numberOfCopiesAvailable = numberOfCopiesAvailable;
    }
    public String getNameOfFirstAuthor(){
            return authors.get(0).getName();
    }

    public String getLiteraryMove(){
            return authors.get(0).getLiteraryMovement();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public boolean isDigitalAvailable() {
        return digitalAvailable;
    }

    public void setDigitalAvailable(boolean digitalAvailable) {
        this.digitalAvailable = digitalAvailable;
    }

    public List<Book> contempAuthor(List<Book> books){

            List<Book> contempb=new ArrayList<>();

            for(Book b: books){
                if(b.getFirstAuthor().getAlive()==true){
                    contempb.add(b);
                }
            }
            return contempb;
    }

    public boolean isAvailable(){
            if(numberOfCopiesAvailable>=1)
                return true;
            else
                return false;
    }

    public void print(){
         System.out.println("ID of the book is: "+id);
         System.out.println("Title of the book is: "+title);
         System.out.println("It is: "+category);
         System.out.println("It has "+pageNo+" pages");
         System.out.println("We have"+numberOfCopiesAvailable+"copies of this book");
         System.out.println("Digital: "+digitalAvailable);
        System.out.print("Written by: ");
        int count=0;
        while(authors.size()>count){
            if(count==0)
                System.out.print(authors.get(count).getName());
            else{
            System.out.print(", "+authors.get(count).getName());
            }
            count++;
        }
        System.out.println();

     }
     public void shortPrint(){

         System.out.print(title+" by ");
         int count=0;
         while(authors.size()>count){
             if(count==0)
                 System.out.print(authors.get(count).getName());
             else{
                 System.out.print(", "+authors.get(count).getName());
             }
             count++;
         }
         System.out.println();
     }

    @Override
    public void AlphabeticalSort(List<Book> b,List<Author>a , int s) {
        if (s == 1){
            for (Book book : b) {
                for (Author au : authors) {
                    au.AlphabeticalSort(null, book.authors, 1); // sort the authors of each book
                }

            }
            if (!b.isEmpty()) {
            Collections.sort(b, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getFirstAuthor().getName().compareTo(o2.getFirstAuthor().getName()); // sort the books by authors name
                }
            });
            }

        } else if(s==2){ // sort by title
            if(!b.isEmpty()){
                Collections.sort(b, new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        return o1.getTitle().compareTo(o2.getTitle());
                    }
                });
            }

        }else if(s==3){
            if(!b.isEmpty()){
                Collections.sort(b, new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        return o1.getLiteraryMove().compareTo(o2.getLiteraryMove()); // sort by literary movement
                    }
                });
            }
        }
    }

    @Override
    public List<Book> SearchTitle(List<Book> b, String title) {
        List<Book> foundBooks=new ArrayList<>();
        for(Book index:b){
            if(index.getTitle().toLowerCase().contains( title.toLowerCase() ) )
                foundBooks.add(index);
        }
        return foundBooks;
    }

    @Override
    public List<Book> SearchAuthor(List<Book> b, String authorName) {
        List<Book> foundBooks=new ArrayList<>();

        for(Book index:b){
            for(Author a : index.getAuthors() ){
                if(a.getName().toLowerCase().contains( authorName.toLowerCase() ) )
                    foundBooks.add(index);
            }
        }
        return foundBooks;
    }

    @Override
    public List<Book> SearchLitMove(List<Book> b, String LiteraryMove) {
        List<Book> foundBooks=new ArrayList<>();
        for(Book index:b){
            if(index.getFirstAuthor().getLiteraryMovement().toLowerCase().contains( LiteraryMove.toLowerCase() ) )
                foundBooks.add(index);
        }
        return foundBooks;
    }
}

package Library;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String name;
    private String literaryMovement; // if the book it is not literar then this field will be null
    private Boolean isAlive;
    private int birthYear;  // this field can be 0 if there is no info about the author
    private int deathYear; // if the author is alive, the value will be 0;
    //private Book[] books;
    private List<Book> books ;

    public Author(String name, String literaryMovement, int birthYear, int deathYear, List<Book> books) {
        this.name = name;
        this.literaryMovement = literaryMovement;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.books = books;
        if( (deathYear == 0) && (birthYear!=0) )
            this.isAlive=true;
        else if((deathYear != 0) && (birthYear!=0))
            this.isAlive=false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLiteraryMovement() {
        return literaryMovement;
    }

    public void setLiteraryMovement(String literaryMovement) {
        this.literaryMovement = literaryMovement;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void printAuthor(){
        System.out.println("The name of the author is: "+name);
        System.out.println("He/She was: "+ literaryMovement);
        if(birthYear==0)
            System.out.println("Alive: no info");
        else
            System.out.println("Alive: "+ isAlive);
        System.out.println("Number of books written:"+books.size());
    }
    public void printOneBook(int idCheck){
        for(Book i:books){
            if(i.getId() == idCheck){
                System.out.println("ID of the book is: "+i.getId());
                System.out.println("Title of the book is: "+i.getTitle());
                System.out.println("It is written by: " + name);
                if(literaryMovement!=null){
                    System.out.println("It is: " + literaryMovement);
                }
                System.out.println("It is: "+i.getCategory());
                System.out.println("Is author alive: "+ isAlive);
                System.out.println("It has "+i.getPageNo()+" pages");
                System.out.println("We have"+i.getNumberOfCopiesAvailable()+"copies of this book");
                System.out.println("Digital: "+i.isDigitalAvailable());
            }
        }

    }

    public void printbook(){
        for(Book i:books){
                System.out.println("ID of the book is: "+i.getId());
                System.out.println("Title of the book is: "+i.getTitle());
                System.out.println("It is written by: " + name);
                if(literaryMovement!=null){
                    System.out.println("It is: " + literaryMovement);
                }
                System.out.println("It is: "+i.getCategory());
                System.out.println("Is author alive: "+ isAlive);
                System.out.println("It has "+i.getPageNo()+" pages");
                System.out.println("We have"+i.getNumberOfCopiesAvailable()+"copies of this book");
                System.out.println("Digital: "+i.isDigitalAvailable());

        }

    }
}

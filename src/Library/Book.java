package Library;

public class Book {

    private int id;
    private int numberOfCopiesAvailable;
    private String title;
    private String category;
    private int pageNo;
    private boolean digitalAvailable;

    private static int indexId=0;

    public Book(int numberOfCopies, String title, String category, int pageNo, boolean digitalAvailable) {
        this.numberOfCopiesAvailable =numberOfCopies;
        this.title = title;
        this.category = category;
        this.pageNo = pageNo;
        this.digitalAvailable = digitalAvailable;
        indexId++;
        this.id=indexId;
    }

    public int getNumberOfCopiesAvailable() {
        return numberOfCopiesAvailable;
    }

    public void setNumberOfCopiesAvailable(int numberOfCopiesAvailable) {
        this.numberOfCopiesAvailable = numberOfCopiesAvailable;
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
     public void print(){
         System.out.println("ID of the book is: "+id);
         System.out.println("Title of the book is: "+title);
         System.out.println("It is: "+category);
         System.out.println("It has "+pageNo+" pages");
         System.out.println("We have"+numberOfCopiesAvailable+"copies of this book");
         System.out.println("Digital: "+digitalAvailable);
     }
}

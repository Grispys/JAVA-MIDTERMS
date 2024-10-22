import java.util.ArrayList;
import java.util.List;



public class LibraryItem {
    private static List<LibraryItem> fullStock = new ArrayList<>();
   
    @SuppressWarnings("unused")
    private String title;
    @SuppressWarnings("unused")
    private String ISBN;
    @SuppressWarnings("unused")
    private String publisher;
    @SuppressWarnings("unused")
    private int availableCopies;
    @SuppressWarnings("unused")
    private String type;
    @SuppressWarnings("unused")
    private String format;

    public LibraryItem(String title, String ISBN, String publisher, int availableCopies, String type, String format){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        if(!type.equals("book") && !type.equals("periodical")){
            System.err.println("Type must be (book) or (Periodical)");
            return;
        }
        if (type.equals("book")) {
            if (!format.equals("physical") && !format.equals("digital") && !format.equals("audio")) {
                System.err.println("Books must be physical, digital, or audio.");
                return;
            }
        }else if (type.equals("periodical")) {
            if (!format.equals("physical") && !format.equals("digital")) {
                System.err.println("Periodicals must be physical, or digital.");
                return;
            }
        }
         
        this.type = type;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.availableCopies = availableCopies;
        this.format = format;

        fullStock.add(this);

    }


    public boolean matchesCriteria(String searchCriteria){
        return title.equalsIgnoreCase(searchCriteria) ||
        ISBN.equalsIgnoreCase(searchCriteria) ||
        publisher.equalsIgnoreCase(searchCriteria) ||
        type.equalsIgnoreCase(searchCriteria) ||
        format.equalsIgnoreCase(searchCriteria);
    }

    public String EditLibrary(String title, String ISBN, String publisher, int availableCopies, String type, String format){
        this.type = type;
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.availableCopies = availableCopies;
        this.format = format;
        return(this.title + "'s details have been updated.");
    }

    public String DeleteLibrary(){
        this.type = null;
        this.title = null;
        this.ISBN = null;
        this.publisher = null;
        this.availableCopies = 0;
        this.format = null;
        return("Item has been removed from the library.");
    }

    public String GetInfo(){
        if(this.ISBN ==null){
            return("This item does not exist.");
        }else{
            return("Item Details: " + this.title + ", " + this.ISBN + ", " + this.publisher + ", " + this.availableCopies + ", " + this.type + ", " + this.format + ".");
        }

    }

    public static List<LibraryItem> getFullStock(){
        return fullStock;
    }

    public String getGeneralInfo(){
        return "Title: " + title + ", ISBN: " + ISBN + ", publisher: " + publisher +
               ", Copies: " + availableCopies + ", Type: " + type + ", Format: " + format;
    }

    public String getTitle(){
        return this.title;
    }

    public int getAvailability(){
        return this.availableCopies;
    }

    public String decreaseAvailable(){
        if(this.availableCopies == 0){
            return("There are no more available copies.");
        }else{
            this.availableCopies = this.availableCopies - 1;
            return("Available copies for " + this.title + " has been decreased by 1.");
        }
    }

    public String increaseAvailable(){
        this.availableCopies = this.availableCopies +1;
        return("Available copies for " + this.title + " has been increased by 1.");
    }

    


}

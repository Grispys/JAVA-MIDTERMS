import java.util.ArrayList;
import java.util.List;



public abstract class LibraryItem {
    protected String Title;
    protected String ISBN;
    protected String Publisher;
    protected int AvailableCopies;
    protected String Format;
    protected static List<LibraryItem> FullStock = new ArrayList<>();

    public LibraryItem(String title, String ISBN, String publisher, int availableCopies, String format) {
        this.Title = title;
        this.ISBN = ISBN;
        this.Publisher = publisher;
        this.AvailableCopies = availableCopies;
        this.Format = format;

        FullStock.add(this);
    }

    // i changed validation from being if statements in the method to be its own method that i override to check different things depending on if its in book or periodical.java
    protected abstract void ValidateFormat();







// criteria checker i used to find items when searching
    public boolean MatchesCriteria(String searchCriteria){
        return Title.equalsIgnoreCase(searchCriteria) ||
        ISBN.equalsIgnoreCase(searchCriteria) ||
        Publisher.equalsIgnoreCase(searchCriteria);
    }
// same deal but exclusively for isbn for when returning a book
    public boolean SelectedItem(String searchCriteria){
        return ISBN.equalsIgnoreCase(searchCriteria);
    }

    // allows to edit a library
    public String EditLibrary(String title, String ISBN, String publisher, int availableCopies, String format){
        this.Title = title;
        this.ISBN = ISBN;
        this.Publisher = publisher;
        this.AvailableCopies = availableCopies;
        this.Format = format;
        return(this.Title + "'s details have been updated.");
    }

    public String DeleteLibrary(){
        this.Title = null;
        this.ISBN = null;
        this.Publisher = null;
        this.AvailableCopies = 0;
        this.Format = null;
        FullStock.remove(this);
        return("Item has been removed from the library.");
    }

    public String GetInfo(){
        if(this.ISBN ==null){
            return("This item does not exist.");
        }else{
            return("Item Details: " + this.Title + ", " + this.ISBN + ", " + this.Publisher + ", " + this.AvailableCopies + ", " + this.Format + ".");
        }

    }
    // returns the stock of a library
    public static List<LibraryItem> GetFullStock(){
        return FullStock;
    }

    public String GetGeneralInfo(){
        return "Title: " + Title + ", ISBN: " + ISBN + ", publisher: " + Publisher +
               ", Copies: " + AvailableCopies + ", Type: " + ", Format: " + Format;
    }

    public String GetTitle(){
        return this.Title;
    }
// looks at availble copies
    public int GetAvailability(){
        return this.AvailableCopies;
    }
// adds by one
    public String DecreaseAvailable(int amount){
        if(this.AvailableCopies == 0){
            return("There are no more available copies.");
        }else{
            if(amount > this.AvailableCopies){
                return("Not enough copies to be borrowed.");
            }else{
                this.AvailableCopies = this.AvailableCopies - amount;
                return("Available copies for " + this.Title + " has been decreased by "+ amount );
            }
          
        }
    }
// decreases by one
    public String IncreaseAvailable(){
        this.AvailableCopies = this.AvailableCopies +1;
        return("Available copies for " + this.Title + " has been increased by 1.");
    }

    public String GetISBN(){
        return this.ISBN;
    }
    


}

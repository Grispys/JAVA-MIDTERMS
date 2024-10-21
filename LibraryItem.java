public class LibraryItem {
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

    


}

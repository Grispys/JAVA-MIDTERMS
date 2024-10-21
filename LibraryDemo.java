// As I am working solo, I combined the Demo and Library classes into one class, hence LibraryDemo. I hope this is not a hindrace!
// this class manages all items, authors, and patrons. I also took the liberty to move the borrow and return functions into the patron
// class because I had already put it there before rereading and seeing it was meant to be here. Oops.

public class LibraryDemo {
    
    
    
    public static void main(String[] args) {
        AuthorManagement author1 = new AuthorManagement("Marcus","20-01-1999");
        Patron patron1 = new Patron("Drake Rose", "12 aberdeen", "958710", "student");

        LibraryItem item1 = new LibraryItem("hello", "1121", "matthew", 5, "periodical", "digital");
        LibraryItem item2 = new LibraryItem("its a me", "6432", "matthew", 3, "book", "audio");
        
        System.err.println(patron1.getInfo());     
        patron1.borrowItem(item2);
        System.out.println(item2.getAvailability());
        patron1.borrowItem(item2);
        patron1.borrowItem(item2);
        patron1.borrowItem(item2);
        patron1.returnItem(item2);

        
        
        author1.addItem(item1);
        author1.addItem(item2);
        author1.getItems();
        author1.removeItem(item2);
        System.out.println(item1.GetInfo());
        item1.EditLibrary("hellow", "232", "notmatthew", 0, "book", "physical");
        author1.getItems();
        author1.deleteAuthor();
        author1.getItems();
        
        
        
        
        System.out.println(item1.GetInfo());
        System.err.println(item1.DeleteLibrary());
        System.out.println(item1.GetInfo());
    }
}

// As I am working solo, I combined the Demo and Library classes into one class, hence LibraryDemo. I hope this is not a hindrace!
// this class manages all items, authors, and patrons. I also took the liberty to move the borrow and return functions into the patron
// class because I had already put it there before rereading and seeing it was meant to be here. Oops.

public class LibraryDemo {
    
    public static void main(String[] args) {
        AuthorManagement author1 = new AuthorManagement("Marcus","20-01-1999");
        Patron patron1 = new Patron("Drake Rose", "12 aberdeen", "958710", "student");

        LibraryItem hello = new LibraryItem("hello", "1121", "marcus", 5, "periodical", "digital");
        LibraryItem its_a_me = new LibraryItem("its a me", "6432", "marcus", 3, "book", "audio");
        
        librarySearch Searcher = new librarySearch();
        System.err.println(patron1.getInfo());     

        System.out.println(its_a_me.getAvailability());


        
        
        author1.addItem(hello);
        author1.addItem(its_a_me);
        author1.getItems();
        author1.removeItem(its_a_me);
        System.out.println(hello.GetInfo());
        hello.EditLibrary("hellow", "232", "notmatthew", 0, "book", "physical");
        author1.getItems();
        author1.deleteAuthor();
        author1.getItems();
        System.out.println();
        System.out.println();
        System.out.println();
        Searcher.search("Marcus");
        
        
        
        System.out.println(hello.GetInfo());
        System.err.println(hello.DeleteLibrary());
        System.out.println(hello.GetInfo());
    }
}


public class LibraryDemo {
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        AuthorManagement author1 = new AuthorManagement("Marcus","20-01-1999");
        AuthorManagement author2 = new AuthorManagement("Douglas","11-06-1980");
        Patron patron1 = new Patron("Drake Rose", "12 aberdeen", "958710", "student");
        Patron patron2 = new Patron("Drew Murphy", "101 wabbadook", "1431660", "employee");

        LibraryItem hello = new LibraryItem("hello", "1121", "marcus", 5, "periodical", "digital");
        LibraryItem its_a_me = new LibraryItem("its a me", "6432", "Douglas", 2, "book", "audio");
        LibraryItem hello1 = new LibraryItem("hello3435", "166121", "marcus", 5, "periodical", "digital");
        LibraryItem hello2 = new LibraryItem("hell2345o", "1177221", "Douglas", 5, "periodical", "digital");
        LibraryItem hello3 = new LibraryItem("hell264o", "112641", "marcus", 5, "periodical", "digital");


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
        // these searches look for books to be borrowed. the search method uses borrowItem method or removeItem method.
        Searcher.search("Marcus", patron1);
        Searcher.search("Marcus", patron1);
        Searcher.search("Douglas", patron2);
        Searcher.search("Marcus", patron1);
        // this search is overloaded to only accept a patron. if this constructor is used, thats when an item is removed instead.
        Searcher.search(patron1);
    }
}

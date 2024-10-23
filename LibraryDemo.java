
public class LibraryDemo {
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // libraryitems get their author attribute from the (addItem) function that belongs to authors. it didn't make much sense to have to define an author in the libraryitem
        // constructor, and then also add the author to the book via that function. so i just have the function. please don't be mad at me :(
        AuthorManagement author1 = new AuthorManagement("Marcus","20-01-1999");
        AuthorManagement author2 = new AuthorManagement("Douglas","11-06-1980");
        Patron patron1 = new Patron("Drake Rose", "12 aberdeen", "958710", "student");
        Patron patron2 = new Patron("Drew Murphy", "101 wabbadook", "1431660", "employee");

        LibraryItem hello = new LibraryItem("hello", "1121", "marcus", 5, "periodical", "digital");
        LibraryItem its_a_me = new LibraryItem("its a me", "6432", "Douglas", 2, "book", "audio");
        LibraryItem hello1 = new LibraryItem("hello3435", "166121", "marcus", 5, "periodical", "digital");
        LibraryItem hello2 = new LibraryItem("hell2345o", "1177221", "Douglas", 5, "periodical", "digital");
        // this ones just to show that the format checks work
        LibraryItem hello3 = new LibraryItem("hell264o", "112641", "marcus", 5, "periodical", "audio");

        // create the searching object
        librarySearch Searcher = new librarySearch();
        
        // get patron info
        System.err.println(patron1.getInfo());     
        // get book availability
        System.out.println(its_a_me.getAvailability());
        

        
        // add items to the author stuff
        author1.addItem(hello);
        author1.addItem(its_a_me);
        author1.getItems();

        // take items out of author
        author1.removeItem(its_a_me);
        System.out.println(hello.GetInfo());
        // edit the library items info
        System.out.println();
        System.out.println();


        Searcher.search("marcus", patron1);
        Searcher.search("Marcus", patron1);
        Searcher.search("Douglas", patron2);
        Searcher.search("Marcus", patron1);


        System.out.println();
        System.out.println();
        hello.EditLibrary("hellow", "232", "notmatthew", 0, "book", "physical");
        hello2.EditLibrary("This is a story", "232426", "Douglas", 99, "book", "physical");
        // check that it worked and delete an author
        author1.getItems();
        author1.deleteAuthor();
        author1.getItems();
        System.out.println();
        System.out.println();
        System.out.println();
        // these searches look for books to be borrowed. the search method uses borrowItem method or removeItem method.
       
        // this search is overloaded to only accept a patron. if this constructor is used, thats when an item is removed instead.
        Searcher.search(patron1);
    }
}

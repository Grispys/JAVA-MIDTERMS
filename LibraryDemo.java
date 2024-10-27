
public class LibraryDemo {
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // libraryitems get their author attribute from the (addItem) function that belongs to authors. it didn't make much sense to have to define an author in the libraryitem
        // constructor, and then also add the author to the book via that function. so i just have the function. please don't be mad at me :(
        AuthorManagement author1 = new AuthorManagement("Marcus","20-01-1999");
        AuthorManagement author2 = new AuthorManagement("Douglas","11-06-1980");
        StudentPatron patron1 = new StudentPatron("Drake Rose", "12 aberdeen", "958710");
        EmployeePatron patron2 = new EmployeePatron("Drew Murphy", "101 wabbadook", "1431660");

        Book hello = new Book("hello", "1121", "marcus", 5, "digital");
        Book its_a_me = new Book("its a me", "6432", "Douglas", 2, "audio");
        Periodical hello1 = new Periodical("hello3435", "166121", "marcus", 5, "digital");
        Periodical hello2 = new Periodical("hell2345o", "1177221", "Douglas", 5, "physical");
        // this ones just to show that the format checks work
        // Periodical hello3 = new Periodical("hell264o", "112641", "marcus", 5, "audio");

        // create the searching object
        librarySearch Searcher = new librarySearch();
        
        // get patron info
        System.out.println(patron1.GetInfo());     
        // get book availability
        System.out.println(its_a_me.GetAvailability());
        

        
        // add items to the author stuff
        author1.AddItem(hello);
        author1.AddItem(its_a_me);
        author1.GetItems();

        // take items out of author
        author1.RemoveItem(its_a_me);
        System.out.println(hello.GetInfo());
        // edit the library items info
        System.out.println();
        System.out.println();


        Searcher.search("marcus", patron1);
        Searcher.search("Marcus", patron1);
        // edit patron testing
        patron1.EditPatron("Drunk Nose", "43 notaberdeen ", "10494134", "student");
        Searcher.search("Douglas", patron2);
        Searcher.search("Marcus", patron1);


        System.out.println();
        System.out.println();
        its_a_me.EditLibrary("hellow", "232", "notmatthew", 0, "physical");
        hello2.EditLibrary("This is a story", "232426", "Douglas", 99, "physical");
        // check that it worked and delete an author
        author1.GetItems();
        author1.DeleteAuthor();
        author1.GetItems();
        // show that you can see their borrowed items list
        System.out.println(patron1.GetBorrowedItemsList());
        
        System.out.println();
        System.out.println();
        // delete user check
        patron2.DeletePatron();
        System.out.println(patron2.GetInfo());
        System.out.println();
        // these searches look for books to be borrowed. the search method uses borrowItem method or removeItem method.
       
        // this search is overloaded to only accept a patron. if this constructor is used, thats when an item is removed instead.
        Searcher.search(patron1);
    }
}

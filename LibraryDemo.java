public class LibraryDemo {
    
    public static void main(String[] args) {
        AuthorManagement author1 = new AuthorManagement("Marcus","20-01-1999");
        LibraryItem item1 = new LibraryItem("hello", "1121", "matthew", 5, "periodical", "digital");
        LibraryItem item2 = new LibraryItem("its a me", "6432", "matthew", 3, "book", "audio");
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

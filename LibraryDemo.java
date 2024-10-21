public class LibraryDemo {
    
    public static void main(String[] args) {
        LibraryItem item1 = new LibraryItem("hello", "1121", "matthew", 5, "periodical", "digital");
        System.out.println(item1.GetInfo());
        item1.EditLibrary("hellow", "232", "notmatthew", 0, "book", "physical");
        System.out.println(item1.GetInfo());
        System.err.println(item1.DeleteLibrary());
        System.out.println(item1.GetInfo());
    }
}

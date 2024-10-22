import java.util.List;
import java.util.ArrayList;


public class AuthorManagement {
    private String name;
    @SuppressWarnings("unused")
    private String DOB;
    private List<LibraryItem> items;


    // constructor
    public AuthorManagement(String name, String DOB){
        this.name = name;
        this.DOB = DOB;
        this.items = new ArrayList<>();
    };

    // add item to their works
    public void addItem(LibraryItem item){
        if(item !=null){
            items.add(item);
            System.out.println("Added " + item.getTitle() + " to this authors bibliography.");
        }else{
            System.err.println("Incorrect item to be added.");
        }
    }

    public void getItems(){
        if(this.name == null){
        System.err.println("This author does not exist.");
        }else if(this.items.isEmpty()){
            System.out.println("This author hasn't written anything.");
        
        }else{
            System.out.println("This author has written: ");
            for(LibraryItem item : items){
                System.out.println("~ " + item.getTitle());
            }
        }
        
    }

    public void removeItem(LibraryItem item){
        items.remove(item);
        System.out.println("Removed " + item.getTitle() + " from this authors bibliography.");
    }

    public void deleteAuthor(){
        this.name = null;
        this.DOB = null;
        this.items = null;
    }

    public void editAuthor(String name, String DOB){
        this.name = name;
        this.DOB = DOB;
        System.out.println("Author details has been updated. To Change their written books, use addItem() or removeItem().");
    }
}

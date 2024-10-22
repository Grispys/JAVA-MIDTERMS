import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Patron {
    private String name;
    private String address;
    private String phoneNum;
    private String patronType;
    private List<LibraryItem> borrowedItems;
    // borrowItem and returnItem are PRIVATE methods instead of public so that in the libraryDemo,
    // they cannot be used freely. They're only called once a user searches and then decides to return or borrow.

    
    private void borrowItem(LibraryItem borrowedItem){
        if(borrowedItem !=null){
            if(borrowedItem.getAvailability() != 0){
                borrowedItems.add(borrowedItem);
                borrowedItem.decreaseAvailable();
                System.out.println("User: " + this.name + " has borrowed: " + borrowedItem.getTitle());
            }else{
                System.err.println("There are no more available copies. Check back soon.");
            }       
        }else{
            System.err.println("Incorrect item to be borrowed.");
        }
    }

    private void returnItem(LibraryItem borrowedItem){
        if(borrowedItem !=null){
            if(!borrowedItems.contains(borrowedItem)){
                System.err.println("This item has not been borrowed by this user.");
            }else{
                borrowedItems.remove(borrowedItem);
                borrowedItem.increaseAvailable();
                System.out.println("User: " + this.name + " has returned: " + borrowedItem.getTitle());
                
            }
        }else{
            System.err.println("Incorrect item to be returned.");
        }
    }


    public Patron(String name, String address, String phoneNum, String patronType){
        if(!patronType.equals("student") && !patronType.equals("employee")){
            System.err.println("Patron must be either a student or an employee.");
            return;
        } 
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.patronType = patronType;
        this.borrowedItems = new ArrayList<>();
    }

    // items are supposed to be searchable via title, author, or isbn. sounds overloaded. if item not available, say so. if
    // it doesnt exist, say so.
    public void selection(){
        Scanner whichItem = new Scanner(System.in);
        LibraryItem selectedItem;
        System.out.println("Which item do you want?");
        selectedItem = whichItem.nextLine();
        System.out.println("You have chosen to borrow: " + selectedItem);
        borrowItem(selectedItem);
    }
    
    
    
    
    public String getInfo(){
        return("User details: " + this.name + ", "+ this.address + ", " + this.phoneNum + ", " + this.patronType);
    }



}

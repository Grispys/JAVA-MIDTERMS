import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Patron {
    private String name;
    private String address;
    private String phoneNum;
    private String patronType;
    private List<LibraryItem> borrowedItemsList = new ArrayList<>();
    // borrowItem and returnItem are PRIVATE methods instead of public so that in the libraryDemo,
    // they cannot be used freely. They're only called once a user searches and then decides to return or borrow.

    
    private void borrowItem(String isbn, int amount) {
        // search for the item in stock by ISBN
        LibraryItem borrowedItem = null;
        for (LibraryItem item : LibraryItem.getFullStock()) {
            if (item.getISBN().equalsIgnoreCase(isbn)) {
                borrowedItem = item;
                break;
            }
        }
    
        // handles borrowing items, updating their availability, and declaring whether its out of stock or doesnt even exist
        if (borrowedItem != null) {
            if (borrowedItem.getAvailability() >= amount) { // check for available copies
                borrowedItemsList.add(borrowedItem);
                String result = borrowedItem.decreaseAvailable(amount);
                System.out.println(result);
                if(!result.equals("Not enough copies to be borrowed.")){ // check the result
                    System.out.println("User: " + this.name + " has borrowed: " + borrowedItem.getTitle());
                }
            } else {
                System.err.println("There are no more available copies and/or not enough copies to be borrowed. Check back soon.");
            }
        } else {
            System.err.println("No item found with ISBN: " + isbn);
        }
    }

    private void returnItem(String isbn) {
        // find the borrowed item that matches the provided. THIS GOES FOR ALL ISBN SEARCHES: i couldnt decide on if i wanted to redo all of the isbn stuff to make it an int. so im keeping it a string
        // with ignoreCase on it in case I change my mind (i probably won't im lazy)
        LibraryItem borrowedItem = null;
        for (LibraryItem item : borrowedItemsList) {
            if (item.getISBN().equalsIgnoreCase(isbn)) {  
                borrowedItem = item;
                break;
            }
        }
    

        if (borrowedItem == null) {
            System.err.println("This item has not been borrowed by this user.");
        } else {

            borrowedItemsList.remove(borrowedItem);
            borrowedItem.increaseAvailable();
            System.out.println("User: " + this.name + " has returned: " + borrowedItem.getTitle());
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
        this.borrowedItemsList = new ArrayList<>();
    }

    public void editPatron(String name, String address, String phoneNum, String patronType){
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.patronType = patronType;
        // borrowed item list does not get a new array list as that will remove any history of items from this user
        System.out.println("User has been updated!");
    }

    public void deletePatron(){
        this.name = null;
        this.address = null;
        this.phoneNum = null;
        this.patronType = null;
        this.borrowedItemsList = null; 
    }

    // the function that gets called in librarySearch to handle borrowing items. uses the borrowitem function.
    @SuppressWarnings("resource")
    public void selection(){
        Scanner whichItem = new Scanner(System.in);
        String selectedItem;
        System.out.println("Please enter the ISBN of the book you want: ");
        selectedItem = whichItem.nextLine();
        int selectedAmount;
        System.out.println("How many copies: ");
        selectedAmount = whichItem.nextInt();
        whichItem.nextLine();
        System.out.println("You have chosen to borrow (" + selectedAmount + ") copies of " + selectedItem );
        borrowItem(selectedItem, selectedAmount);
    }
    // the function that gets called in librarySearch to handle returning items. uses the returnitem function.
    @SuppressWarnings("resource")
    public void returning(){
        Scanner chooser = new Scanner(System.in);
        String chosenItem;
        System.out.println("Enter the ISBN of the item you are returning: ");
        chosenItem = chooser.nextLine();
        System.out.println("You have returned: " + chosenItem);
        returnItem(chosenItem);
    }
    
    
    
    // shows user details
    public String getInfo(){
        if(this.name == null){
            return("User does not exist.");
        }else{
            return("User details: " + this.name + ", "+ this.address + ", " + this.phoneNum + ", " + this.patronType);
        }
        
    }

    // returns the list of borroweditems
    public List<LibraryItem> getBorrowedItems(){
        return borrowedItemsList;
    }





}

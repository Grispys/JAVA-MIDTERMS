import java.util.List;
import java.util.Scanner;
// items are supposed to be searchable via title, author, or isbn. sounds overloaded. if item not available, say so. if
// it doesnt exist, say so. then run the selection method to see what they're borrowing.
public class librarySearch {
    public void search(String searchCriteria, Patron name){
        boolean match = false;
        for(LibraryItem item : LibraryItem.GetFullStock()){
            if(item.MatchesCriteria(searchCriteria)){
                System.out.println("Matches: " + item.GetInfo());
                match = true;
            }
            
        }
        name.Selection();
        if(!match){System.out.println("No matches found for : " + searchCriteria);}
    }

    // this is for RETURNING books they have already borrowed. checks their borrowed list, then asks if they want to return anything, then they can enter the isbn and the returning method
    // is called to handle that.
    public void search(Patron name){
        System.out.println("You have borrowed: ");
        List<LibraryItem> borrowedItemsList = name.GetBorrowedItems();
       
        for(LibraryItem item : borrowedItemsList){
            System.out.println("    -" + item.GetTitle() + "," + item.GetISBN());
        }
        @SuppressWarnings("resource")
        Scanner decider = new Scanner(System.in);
        String decision;
        System.out.println("Would you like to return an item?");
        decision = decider.nextLine();
        if(decision.equals("no")){
            System.out.println("Have a good day.");
        }else if(decision.equals("yes")){
            name.Returning();
        }else{
            System.out.println("Please enter 'yes' or 'no'.");
        }


           
    }
}

public class librarySearch {
    public void search(String searchCriteria){
        boolean match = false;
        for(LibraryItem item : LibraryItem.getFullStock()){
            if(item.matchesCriteria(searchCriteria)){
                System.out.println("Matches: " + item.GetInfo());;
                match = true;
            }
        }
        if(!match){System.out.println("No matches found for : " + searchCriteria);}
    }
}

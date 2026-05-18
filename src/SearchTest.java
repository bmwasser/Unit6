public class SearchTest {

    static Deck d;

    public static void main(String[] args) {
        d = new Deck();  // Cards should be created in their Comparable order
        d.deal();			// remove one card to test the "not found" behavior
	    searchCards("In order");
        d.shuffle();
        searchCards("shuffled");
    }
    
    public static void searchCards(String test){
        int searchFailures = 0;
        for (int rank = 1; rank <= 13; rank++){
            for (int suit = 0; suit <= 3; suit++){
                Card temp = new Card(rank, suit);
                if (d.linearSearch(temp) != d.binarySearch(temp)){
                    System.out.print("Linear search found the " + temp + " at: " + d.linearSearch(temp));
                    System.out.println(" but binary search found it at: " + d.binarySearch(temp));
                    searchFailures++;
                }
            }
        }
        System.out.println(test + ": There were " + searchFailures + " search mismatches between linear and binary search.");
    }
    
}

import java.util.List;
import java.util.ArrayList;

public class Deck {
    
    private List<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
        for (int rank = 1; rank <= 13; rank++){
            for (int suit = 0; suit <= 3; suit++){
                deck.add(new Card(rank, suit));  
            }
        }
    }

    public Card deal(){
        Card dealt = deck.remove(0);
        return dealt;
    }

    public int getCardsLeft(){
        return deck.size();
    }

    public void shuffle(){
        for (int i = 0; i <= 1000; i++){
            int randomNumber = (int) (Math.random() * deck.size());
            Card shuffled = deck.remove(randomNumber);
            deck.add(shuffled);
        }
    }

    public int linearSearch(Card target){
        for (int i = 0; i < this.deck.size(); i++) {
            // Assumes Card class has a proper .equals() method
            if (this.deck.get(i).equals(target)) {
                return i; // Found: return the index
            }
        }
        return -1;
    }

    public int binarySearch(Card temp) {
        int high = deck.size() - 1;
        int low = 0; 
        while (low <= high){
            int mid = low + (high - low) / 2;
            Card midCard = deck.get(mid);
            int comparison = midCard.compareTo(temp);
            if (comparison == 0) {
                return mid; // Match found
            } else if (comparison < 0) {
                low = mid + 1; // Target is higher, search the right half
            } else {
                high = mid - 1; // Target is lower, search the left half
            }
        }

        return -1;
    }

    public void selectionSort(){
        for (int i = 0; i < deck.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < deck.size(); j++) {
                if (deck.get(j).compareTo(deck.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            Card temp = deck.get(minIndex);
            deck.set(minIndex, deck.get(i));
            deck.set(i, temp);
        }
    }

    public void insertionSort(){
       for (int i = 1; i < deck.size(); i++) {
            Card sortCard = deck.get(i); 
            int j = i - 1;
            while (j >= 0 && deck.get(j).compareTo(sortCard) > 0) {
                deck.set(j + 1, deck.get(j));
                j = j - 1;
            }
            deck.set(j + 1, sortCard);
        }
    }

    public void mergeSort(){
        deck = mergeSort(deck);
    }

    /**
     * Receives a List of Cards and recursively sorts it,
     * returning a NEW List of Cards that is in order
     * @param original
     * @return
     */
    public List<Card> mergeSort(List<Card> original){
        // base case
        if (original.size() <= 1) return original;   
        // split the list into two parts - do this manually (for loop)
        List<Card> firstHalf = new ArrayList<>();
        List<Card> secondHalf = new ArrayList<>();
        int mid = original.size() / 2;
        for (int i = 0; i < original.size(); i++){
            if (i < mid){
                firstHalf.add(original.get(i));
            } else {
                secondHalf.add(original.get(i));
            }
        }
        // mergeSort each half (recursion)
        firstHalf = mergeSort(firstHalf);
        secondHalf = mergeSort(secondHalf);
        // merge those halves into a new list (4 to 6 lines of code) (compareTo)
        List<Card> sortedDeck = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstHalf.size() && j < secondHalf.size()){
            if (firstHalf.get(i).compareTo(secondHalf.get(j)) < 0){
                sortedDeck.add(firstHalf.get(i++));
            } else {
                sortedDeck.add(secondHalf.get(j++));
            }
        }
        while (i < firstHalf.size()) {
            sortedDeck.add(firstHalf.get(i++));
        }
        while (j < secondHalf.size()) {
            sortedDeck.add(secondHalf.get(j++));
        }
        // return that list
        return sortedDeck;
    }

    public String toString() {
        String str = "";
        for (Card c : deck) {
            str += c;
            str += "\n";
        }
        return str;
    }

    public void addAll(ArrayList<Card> cardsToAdd) {
        this.deck.addAll(cardsToAdd); // 'cards' is your internal ArrayList
    }

}

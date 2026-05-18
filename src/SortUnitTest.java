public class SortUnitTest {

    public static void main(String[] args) {
        Deck d = new Deck();
        d.shuffle();
        d.mergeSort();
        
        int cardCount = 0;
        Card previous = new Card(1, 0);
        boolean inOrder = true;
        int[] cardHist = new int[53];
        boolean noDuplicates = true;
        while (d.getCardsLeft() > 0){
            Card current = d.deal();
            int cardNum = ((current.getRank() - 1) * 4) + current.getSuit() + 1;
            cardHist[cardNum]++;
            if (cardHist[cardNum] > 1){
                noDuplicates = false;
            }
            if (previous.compareTo(current) > 0){
                System.out.println(previous + " and " + current + " are out of order");
                inOrder = false;
            }
            previous = current;
            cardCount++;
        }
        System.out.println("Correct number of cards in the deck: " + (cardCount == 52));
        System.out.println("Cards are in the correct order: " + inOrder);
        System.out.println("Each card has exactly one of each: " + noDuplicates);



    }
}
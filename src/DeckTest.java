public class DeckTest {
    
    public static void main(String[] args){
        Deck myCards = new Deck();
        System.out.println(myCards);
        System.out.println(myCards.deal());
        System.out.println(myCards.getCardsLeft());

        Deck playingCards = new Deck();
        System.out.println(playingCards);
        System.out.println();
        playingCards.shuffle();
        System.out.println("Shuffled deck of cards: " + playingCards);
        System.out.println();
        System.out.println(playingCards.deal());
        System.out.println();
        System.out.println("New shuffled deck of cards: " + playingCards);
    }
    


}

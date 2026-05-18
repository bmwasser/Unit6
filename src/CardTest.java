public class CardTest {
    
    public static void main(String[] args) throws Exception {
        Card c1 = new Card(4,3);
        Card c2 = new Card(10,2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.equals(c2));
        System.out.println(c2.compareTo(c1));
        System.out.println(c2.getRank());
        System.out.println(c1.getSuit());
        Card[] cards = Card.makeDeck();
        Card.printDeck(cards);
        
    }





}

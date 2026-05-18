public class PlayerTest{

    public static void main(String[] args){
        Player p1 = new Player("Braeden");
        Player p2 = new Player("Cameron");
        Deck playingCards = new Deck();
        playingCards.shuffle();
        p1.take(playingCards.deal());
        p1.take(playingCards.deal());
        p1.take(playingCards.deal());
        p2.take(playingCards.deal());
        p2.take(playingCards.deal());
        p2.take(playingCards.deal());
        System.out.println(p1);
        System.out.println(p2);

    }




}
import java.util.ArrayList;
import java.util.List;

public class Player {
    
    private List<Card> hand;
    private String playerName;

    public Player(String name){
        this.playerName = name;
        this.hand = new ArrayList<>();
    }

    public void take(Card newCard){
        hand.add(newCard);
    }

    public ArrayList<Card> fold(){
        ArrayList<Card> foldedCards = new ArrayList<>(this.hand);
        this.hand.clear(); 
        return foldedCards;
    }

    public int getScore(){
        return 0;
    }

    public String toString(){
        String str = "";
        for (Card c : hand) {
            str += c;
            str += "\n";
        }
        return str;
    }

    public List<Card> getHand(){
        return this.hand;
    }

    public String getName(){
        return this.playerName;
    }






}

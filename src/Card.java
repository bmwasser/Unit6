import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card {
    
    private final int rank;
    private final int suit;
    public static final String[] RANKS = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private BufferedImage face;
    private static BufferedImage back;

    static {
        String filename = "images/back01.png";
        try {
            back = ImageIO.read(new File(filename));
        } catch (IOException e) {
            back = null;
            System.err.println(e + " file: " + filename);
        } 
    }
    
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
        int fileNumber = ((this.rank - 1) * 4) + this.suit + 1; // card 30 is 8 of diamonds
        String filename = String.format("images/card%02d.png", fileNumber);
        try {
            this.face = ImageIO.read(new File(filename));
        } catch (IOException e) {
            this.face = null;
            System.err.println(e + " file: " + filename);
        }
    }
    
    public BufferedImage getFace(){
        return this.face;
    }

    public BufferedImage getBack(){
        return back;
    }

    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }

    public boolean equals(Card that) {
        return this.compareTo(that) == 0;
    }

    public int compareTo(Card that) {
        if (this.rank != that.rank){
            return this.rank - that.rank;
        }
        return this.suit - that.suit;
    }
    
    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }


    public static Card[] makeDeck() {
    Card[] cards = new Card[52];
    int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        return cards;
    }

    public static void printDeck(Card[] cards) {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BlackjackPanel extends JPanel implements KeyListener, MouseListener{

    private BlackjackPlayer p1;
    private BlackjackPlayer dealer;
    private Deck playingDeck;
    private ArrayList<Card> discardPile;
    private String state;
    private char userInput;
    private String statusMessage;
    private int fps = 80;
    private final int CARD_WIDTH = 256;
    private final int CARD_HEIGHT = 372;

    public BlackjackPanel(int w, int h) {
        setPreferredSize(new Dimension(w, h));
        setBackground(new Color(6, 64, 43));
        p1 = new BlackjackPlayer("Braeden");
        dealer = new BlackjackPlayer("Dealer");
        playingDeck = new Deck();
        discardPile = new ArrayList<>();
        state = "READY";
        userInput = '!';
        statusMessage = "Blackjack";
        addKeyListener(this);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(statusMessage, 100, 380);
        g.setColor(Color.WHITE);
        g.fillRect(260, 35, 87, 25);
        g.setColor(Color.BLACK);
        g.drawString("Blackjack Game", 260, 50);
        int xPos = 50;
        int xPos2 = 50;
        for (Card c : p1.getHand()){
            BufferedImage img = c.getFace();
            g.drawImage(c.getFace(), xPos, 75, CARD_WIDTH / 3, CARD_HEIGHT / 3, null);
            xPos += 100;
        }
        for (Card c : dealer.getHand()){
            BufferedImage dealerImg = c.getFace();
            g.drawImage(c.getFace(), xPos2, 140, CARD_WIDTH / 3, CARD_HEIGHT / 3 , null);
            xPos2 += 100;
        }
    }

    public void run() {
        while (true) {
            update();  
            repaint();
            delay(1000 / fps);
        }
    }

    public void update() {
        if (state.equals("READY")){
            if (userInput == 'r'){
                userInput = '!';
                state = "DEAL";
            }
        } else if (state.equals("DEAL")){
            playingDeck.shuffle();
            p1.take(playingDeck.deal());
            p1.take(playingDeck.deal());
            dealer.take(playingDeck.deal());
            state = "PLAYER1";

        } else if (state.equals("PLAYER1")){
            if (p1.getScore() > 21) {
                state = "SHOW"; // Instant bust
            } else if (p1.shouldHit(p1.getScore(), dealer.getScore())){ // implement a shouldHit method into BlackjackPlayer which mirrors chart
                p1.take(playingDeck.deal());
                if (p1.getScore() > 21) {
                    state = "SHOW";
                }
            } else {
                // Player chooses to STAND
                state = "DEALER";
                userInput = '!'; 
            } 
        } else if (state.equals("DEALER")){
            if (dealer.getScore() >= 17) {
                state = "SHOW";
            } else {
                dealer.take(playingDeck.deal());// Dealer is 17 or higher, STOP immediately
            }
        } else if (state.equals("SHOW")){
            int win = BlackjackPlayer.getWinner(p1, dealer); //change method to int for -1, 0, 1
            if ((p1.record(win) % 100) == 0){ // implement record win and lose method and returns how many times the game has been played and takes win
                System.out.println(p1.calculateEdge());
            }
            if (true) {
                discardPile.addAll(p1.fold());
                discardPile.addAll(dealer.fold());
    
                if (playingDeck.getCardsLeft() < 10) {
                    playingDeck.addAll(discardPile);
                    discardPile.clear();
                    playingDeck.shuffle();
                }
                state = "DEAL";
            }  
        } else {
            throw new RuntimeException("Unknown state: " + state);
        }

    }

    public void delay(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // call event handling methods
            // use sysouts for debugging like this:
            // System.out.println("The left arrow was pressed");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // call event handling methods
        }
    }

    public void keyTyped(KeyEvent e) {
        userInput = e.getKeyChar();
    }

    public void mouseClicked(MouseEvent e) {
        // called when the mouse is pressed and released quickly
    }

    public void mouseEntered(MouseEvent e) {
        // called when the mouse enters the window
    }

    public void mouseExited(MouseEvent e) {
        // called when the mouse leaves the window
    }

    public void mousePressed(MouseEvent e) {
        // set a variable based on mouse coordinates
        // or check a condition based on mouse coordinates
    }

    public void mouseReleased(MouseEvent e) {
        // set a variable based on mouse coordinates
        // or check a condition based on mouse coordinates
    }
}


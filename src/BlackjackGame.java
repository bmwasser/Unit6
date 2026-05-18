import java.util.Scanner;

public class BlackjackGame {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BlackjackPlayer p1 = new BlackjackPlayer("Braeden");
        BlackjackPlayer dealer = new BlackjackPlayer("Dealer");

        Deck d = new Deck();
        d.shuffle();
        p1.take(d.deal());
        p1.take(d.deal());
        dealer.take(d.deal());

        System.out.println(p1);
        System.out.println();
        System.out.println(dealer);
        System.out.println();

        String response = " ";
        while (response.toLowerCase().charAt(0) != 's' && p1.getScore() <= 21) {
            System.out.print("Do you wish to hit or stand?");
            response = in.nextLine();
            if (response.toLowerCase().charAt(0) == 'h'){
                p1.take(d.deal());
                System.out.println();
                System.out.println(p1);
            }
        }

        if (p1.getScore() >= 22){
            System.out.println("You LOSE");
        }
        
        
        
        

    }

}

public class BlackjackPlayer extends Player {

    // by exteding Player, everything in Player is included in a BlackjackPlayer
    // all attributes, construcvtors, methods
    // HOWEVER, they can only be called directly if they are not private

    // does a BlackjackPlayer need any additional attributes?

    private int wins;
    private int loses;
    public static BlackjackPlayer winner;
    private int handsPlayed;

    public BlackjackPlayer(String name) {
        super(name);
        this.wins = 0;
        this.loses = 0;
    }

    @Override
    public int getScore() {
        int totalScore = 0;
        int aceCount = 0;
        for (Card card : getHand()){
            int rank = card.getRank();
            if (rank > 10){
                totalScore += 10;
            } else if (rank == 1){
                totalScore += 1;
                aceCount++;
            } else {
                totalScore += rank;
            }
        }

        while (aceCount > 0 && totalScore + 10 <= 21){
            totalScore += 10;
            aceCount--;
        }

        return totalScore;
    }

    @Override
    public String toString(){
        return super.toString() + "Score:" + this.getScore() + "Wins:" + this.wins;
    }

    public static int getWinner(BlackjackPlayer p1, BlackjackPlayer p2){
        int pScore = p1.getScore();
        int dScore = p2.getScore();

        if (pScore > 21) return -1; // Player bust
        if (dScore > 21) return 1;  // Dealer bust

        // Blackjack priority check
        if (p1.isBlackjack() && !p2.isBlackjack()) return 1;
        if (!p1.isBlackjack() && p2.isBlackjack()) return -1;
        if (p1.isBlackjack() && p2.isBlackjack()) return 0;

        // Standard score comparison
        if (pScore > dScore) return 1;
        if (dScore > pScore) return -1;
        return 0;

    }
    
    public int record(int win){
        if (win > 0) this.wins += 1;
        if (win < 0) this.loses += 1;
        this.handsPlayed++;
        return this.handsPlayed;
        // returns iteration times
    }

    public double calculateEdge(){
        return (double) (this.wins - this.loses) / this.handsPlayed;
    }

    public boolean isBlackjack() {
        return getHand().size() == 2 && this.getScore() == 21;
    }   

    public boolean shouldHit(int playerTotal, int dealerUpcard){
        if (playerTotal >= 17) return false;

        if (playerTotal <= 11) return true;
        if (playerTotal == 12) return !(dealerUpcard >= 4 && dealerUpcard <= 6);
        if (playerTotal >= 13 && playerTotal <= 16) return (dealerUpcard >= 7);
        return false;
    }



}
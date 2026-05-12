public class Player {

    public boolean isDealer = false;
    public int numPlayer;
    public Card [] hand;
    public int numCards;
    public boolean isBust;

    public int cardValue;

    public static void main(String[] args) {
        Player player = new Player();
    }


    public Player (int pnumPlayer){
        numPlayer = pnumPlayer;
        hand = new Card [11];
        numCards = 0;
        isBust = false;
    }

    public void printPlayer(){
        for (int i = 0; i < numCards; i++){
            hand[i].printCard();
        }
    }

    public void addCard(Card newCard){
        hand [numCards] = newCard;
        numCards++;
    }

    public void getHandTotal(){
        int total = 0;
        for (int i = 0; i < numCards; i++){
            if (hand[i].value == 0) {
                total += 11;
            } else if (hand[i].value >= 10) {
                total += 10;
            } else {
                total += hand[i].value + 1;
            }
            hand[i].printCard();
        }
    }


    }
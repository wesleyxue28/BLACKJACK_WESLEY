public class Player {

    public boolean isDealer = false;
    public int numPlayer;
    public Card [] hand;
    public int numCards;
    public boolean isBust;
    public int sumCards = 0;

    public int cardValue;

    public static void main(String[] args) {
        Player player = new Player(1);

    }


    public Player (int pnumPlayer){
        numPlayer = pnumPlayer;
        hand = new Card [11];
        numCards = 0;
        isBust = false;
        printPlayer();
//        addCard(new Card(6,"Spade",true));
        getHandTotal();
        bustCard();
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
        int sumCards = 0;
        for (int i = 0; i < numCards; i++){
            if (hand[i].value == 0) {
                sumCards += 11;
            } else if (hand[i].value >= 10) {
                sumCards += 10;
            } else {
                sumCards += hand[i].value + 1;
            }
            hand[i].printCard();
            System.out.println(sumCards);
        }
    }

    public void bustCard(){
        if (sumCards < 21){
            isBust = false;
            System.out.println(sumCards);
        }
        else if (sumCards > 21){
            isBust = true;
            System.out.println(sumCards);
        }
        else{
            isBust = false;
            System.out.println("Black ");
            System.out.println(sumCards);
        }
    }

    }
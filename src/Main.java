import java.util.Scanner;

public class Main {
    public Card card1;
    public Card [] deck;
    public int numCards;
    Player player1;
    Player dealer;
    public static void main(String[] args) {
        Main myapp = new  Main();
    }
    public Main() {
        deck = new Card [52];
        for (int i = 0; i < deck.length; i++) {
           if (i < 13){
               deck[i] = new Card(i, "Spades", false);
           }
           else if (i<26){
               deck[i] = new Card(i%13, "Diamonds", false);
           }
           else if (i<39){
               deck[i] = new Card(i%13, "Hearts", false);
           }
           else if (i<52){
               deck[i] = new Card(i%13, "Clubs", false);
           }
        }
        shuffle();
        printDeck();
        player1 = new Player(1);

        player1.addCard(deck[numCards]);
        numCards++;
        player1.addCard(deck[numCards]);
        numCards++;
        player1.getHandTotal();
        player1.bustCard();
        player1.printPlayer();
        //dealer

       takeTurn();
       dealerTurn();
       compareHands();
    }

  public void printDeck(){
      System.out.println("This deck: ");
    for (int i = 0; i < deck.length; i++){
        deck[i].printCard();
    }
  }

  public void shuffle(){
        for (int i = 0; i < deck.length; i++){
            int randNum = (int) (Math.random() * 52);
            Card holdCard = deck[randNum];
            deck[randNum] = deck[i];
            deck[i] = holdCard;
            }
        }
    public void takeTurn() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Player " + 1 + ", type 'hit' or 'stand': ");
            String input = sc.nextLine();

            if (input.equals("hit")) {
                player1.addCard(deck[numCards]);
                numCards++;
                player1.getHandTotal();
                player1.printPlayer();
                player1.bustCard();
                if (player1.isBust) {
                    System.out.println("Player " + 1 + "busts!");
                    break;
                }
            } else if (input.equals("stand")) {
                System.out.println("Player " + 1 + " stands with " + player1.sumCards);
                break;
            } else {
                System.out.println("Try again. Please type 'hit' or 'stand'.");
            }
        }
    }

    public void dealerTurn(){
        Player dealer = new Player(2);
        dealer.addCard(deck[numCards++]);
        dealer.addCard(deck[numCards++]);
        dealer.getHandTotal();
        System.out.println("Dealer's hand: ");
        dealer.printPlayer();

        while (dealer.sumCards < 17){
            System.out.println("Dealer hits: ");
            dealer.addCard(deck[numCards++]);
            dealer.getHandTotal();
            dealer.printPlayer();
            dealer.bustCard();
            if (dealer.isBust){
                System.out.println("Dealer busts! Player wins!");
                return;
            }
        }
        System.out.println("Dealer stands at "+ dealer.sumCards);
        }

    public void compareHands(){
        System.out.println("Player: "+ player1.sumCards);
        System.out.println("Dealer: "+ dealer.sumCards);

        if (player1.isBust){
            System.out.println("Player bust! Dealer wins!");
        }
        else if (dealer.isBust){
            System.out.println("Dealer bust! Player wins!");
        }
        else if (player1.sumCards < dealer.sumCards){
            System.out.println("Dealer wins!");
        }
        else if (dealer.sumCards < player1.sumCards){
            System.out.println("Player wins!");
        }
        else{
            System.out.println("Tie! ");
        }
    }




    }






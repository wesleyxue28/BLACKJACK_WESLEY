import java.util.Scanner;

public class Main {
    public Card card1;
    public Card [] deck;
    public int numCards;
    public static void main(String[] args) {
        Main myapp = new Main();
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
        Player player1 = new Player(1);

        player1.addCard(deck[numCards]);
        numCards++;
        player1.addCard(deck[numCards]);
        numCards++;
        player1.getHandTotal();
        player1.printPlayer();
        //dealer

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Player 1 what do you want to do: ");
            String input = sc.nextLine();

        }
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
  }


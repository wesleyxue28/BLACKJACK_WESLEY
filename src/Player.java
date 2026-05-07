public class Player {

    public String name;
    public Card[] hand;
    public int handCount;
    public int chips;

    public Player(String pName, int pChips) {
        name = pName;
        chips = pChips;
        hand = new Card[10];
        handCount = 0;
    }
    
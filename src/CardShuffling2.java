import java.util.ArrayList;

public class CardShuffling2 {

    // THE FIRST ELEMENT IN THE ARRAYLIST REPRESENTS THE TOP OF THE DECK

    private ArrayList<Integer> currDeck;
    private ArrayList<Integer> originalDeck;
    private ArrayList<Integer> table;

    public CardShuffling2(ArrayList<Integer> inputDeck) {
        currDeck = new ArrayList<Integer>();
        originalDeck = new ArrayList<Integer>();
        for (int i = 0; i < inputDeck.size(); i++) {
            currDeck.add(inputDeck.get(i));
            originalDeck.add(inputDeck.get(i));
        }
        table = new ArrayList<Integer>();
    }

    public int getNumberOfRounds() {
        int rounds = 0;
        boolean goesToTable = true;
        do {

        } while (isOriginalOrder() == false);
        return rounds;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // HELPER METHODS
    //////////////////////////////////////////////////////////////////////////////////////////////////

    public void deckToTable() {
        int topCard = currDeck.get(0);
        currDeck.remove(0);
        table.add(topCard);
    }

    public boolean isOriginalOrder() {
        for (int i = 0; i < originalDeck.size(); i++) {
            if ((originalDeck.get(i) == currDeck.get(i)) == false)
                return false;
        }
        return true;
    }

    public void printDeck(ArrayList<Integer> deck) {
        for (int i = 0; i < deck.size(); i++) {
            System.out.print(deck.get(i) + "  ");
        }
        System.out.println();
    }

}
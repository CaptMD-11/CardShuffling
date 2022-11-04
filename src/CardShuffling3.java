import java.util.ArrayList;

public class CardShuffling3 {
    private ArrayList<Integer> originalDeck;
    private ArrayList<Integer> hand;
    private ArrayList<Integer> table;

    public CardShuffling3(ArrayList<Integer> inputDeck) {
        originalDeck = new ArrayList<Integer>();
        for (int i = 0; i < inputDeck.size(); i++) {
            originalDeck.add(inputDeck.get(i));
        }
        hand = new ArrayList<Integer>();
        for (int i = 0; i < originalDeck.size(); i++) {
            hand.add(originalDeck.get(i));
        }
        table = new ArrayList<Integer>();
    }

    public boolean isOriginal(ArrayList<Integer> hand) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i) != originalDeck.get(i))
                return false;
        }
        return true;
    }

    public int getNumberOfRounds() { // first element in ArrayList represents top card of the deck
        boolean goesToTable = true;
        int rounds = 0;
        do {
            // transfer of cards from hand to table
            table.add(hand.remove(0));
            goesToTable = !goesToTable;
            while (hand.size() != 0) {
                if (goesToTable) {
                    table.add(0, hand.remove(0));
                } else {
                    hand.add(hand.remove(0));
                }
                goesToTable = !goesToTable;
            }
            rounds++;
            for (int i = 0; i < table.size(); i++) {
                hand.add(table.get(i));
            }
            table.clear();
        } while (isOriginal(hand) == false);
        return rounds;
    }
}
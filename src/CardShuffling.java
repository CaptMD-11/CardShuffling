import java.util.ArrayList;

public class CardShuffling {

    private CardShuffling() {

    }

    private boolean isOriginalOrder(String[][] originalDeck, ArrayList<String[]> curr) {
        for (int i = 0; i < originalDeck.length; i++) {
            for (int j = 0; j < originalDeck[i].length; j++) {
                if (originalDeck[i][j].equals(curr.get(i)[j]) == false)
                    return false;
            }
        }
        return true;
    }

    public int getNumberOfRounds(ArrayList<String[]> deck) {
        boolean goesToTable = true;
        int count = 0;
        String[][] originalDeck = new String[deck.size()][2];

        for (int i = 0; i < deck.size(); i++) {
            originalDeck[i][0] = deck.get(i)[0];
            originalDeck[i][1] = deck.get(i)[1];
        }

        ArrayList<String[]> table = new ArrayList<String[]>();

        while (isOriginalOrder(originalDeck, deck) == false) {
            for (int i = 0; i < deck.size(); i++) {
                if (goesToTable == true)
                    table.add(deck.get(i));
                else
                    deck.add(deck.remove(i));
                goesToTable = !goesToTable;
            }
            count++;
        }
        return count;
    }

}

import java.util.ArrayList;

public class CardShuffling {

    private CardShuffling() {

    }

    private static boolean isOriginalOrder(ArrayList<Integer> originalDeck, ArrayList<Integer> curr) {
        for (int i = 0; i < originalDeck.size(); i++) {
            if (originalDeck.get(i) == curr.get(i) == false)
                return false;
        }
        return true;
    }

    public static void printDeck(ArrayList<Integer> deck) {
        for (int i = 0; i < deck.size(); i++) {
            System.out.print(deck.get(i) + "  ");
        }
        System.out.println();
    }

    public static int getNumberOfRounds(ArrayList<Integer> deck) {
        boolean goesToTable = true;
        int count = 0;
        ArrayList<Integer> originalDeck = new ArrayList<Integer>();

        for (int i = 0; i < deck.size(); i++) {
            originalDeck.add(deck.get(i));
        }

        ArrayList<Integer> table = new ArrayList<Integer>();
        int deckSize = deck.size();

        do {

            printDeck(deck);

            while (deckSize != 0) {
                if (goesToTable == true) {
                    table.add(0, deck.remove(0));
                    deckSize--;
                } else {
                    deck.add(deck.remove(0));
                }
                goesToTable = !goesToTable;
            }
            for (int i = 0; i < table.size(); i++) {
                deck.add(table.get(i));
            }
            table = new ArrayList<Integer>(1);
            deckSize = table.size();
            count++;
        } while (isOriginalOrder(originalDeck, deck) == false);

        return count;
    }

}

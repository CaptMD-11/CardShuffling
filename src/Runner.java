import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {

        ArrayList<Integer> deck = new ArrayList<Integer>();

        deck.add(1);
        deck.add(2);
        deck.add(3);
        deck.add(4);
        deck.add(5);

        CardShuffling3 obj = new CardShuffling3(deck);

        System.out.println(obj.getNumberOfRounds());

    }
}
import java.util.ArrayList;

public class Player {

    String name;
    int totalPoints;
    ArrayList<Card> hand = new ArrayList();


    public int getTotalPoints() {

        for(int i = 0; i <= hand.size() - 1; i++){
            totalPoints += hand.get(i).getPoints();
        }

        return totalPoints;
    }
}

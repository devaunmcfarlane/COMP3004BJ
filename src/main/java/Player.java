import java.util.ArrayList;


public class Player {

    String name;

    ArrayList<Card> hand = new ArrayList();

    Player(String name){
        this.name = name;
    }

    public int getTotalPoints() {
        int totalPoints = 0;
        for(int i = 0; i <= hand.size() - 1; i++){
            totalPoints += hand.get(i).getPoints();
        }

        return totalPoints;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){this.name = name;}
    public ArrayList<Card> getHand(){
        return hand;
    }
}

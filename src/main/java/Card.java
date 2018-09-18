
public class Card {
    int pointValue;
    String suite;
    String value;

    Card(String suit, String value) {
        this.suite = suit;
        this.value = value;
        if(value.equals("Jack") || (value.equals("Queen"))|| (value.equals("King"))){
            pointValue = 10;
        }

        else if (value.equals("Ace")){

        }

        else{
            pointValue = Integer.parseInt(value);
        }
    }

    public String getSuite(){
        return suite;
    }

    public String getValue(){
        return value;
    }

    public int getPoints(){
        return pointValue;
    }

    public void setPoints(int newPoints){
        this.pointValue = newPoints;
    }
}




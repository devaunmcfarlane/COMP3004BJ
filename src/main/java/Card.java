
public class Card {
    private int pointValue;
    private String suite;
    private String value;
    private boolean visibility;

    Card(String suit, String value) {
        this.suite = suit;
        this.value = value;
        this.visibility = false;
        if(value.equals("Jack") || (value.equals("Queen"))|| (value.equals("King"))){
            pointValue = 10;
        }

        else if (value.equals("Ace")){
            //Nothing Here We'll deal with that later
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

    public String toString(){
        return value + " of " + suite;
    }

    private void setVisibility(boolean bool){
        this.visibility = bool;
    }
}




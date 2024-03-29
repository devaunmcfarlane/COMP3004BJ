
public class Card {
    private int pointValue;
    private String suite;
    private String value;
    private boolean visibility;

    Card(String suit, String value) {
        this.suite = suit;
        this.value = value;
        this.visibility = true;
        if(value.equals("Jack") || (value.equals("Queen"))|| (value.equals("King"))){
            pointValue = 10;
        }

        else if (value.equals("Ace")){
            pointValue = 1;
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

        if(visibility == true) {
            return value + " of " + suite;
        }

        else{
            return "?";
        }
    }

    public void setVisibility(boolean bool){
        this.visibility = bool;
    }

    public boolean getVisibility() {return visibility;}
}




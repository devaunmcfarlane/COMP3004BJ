enum Suite {Hearts, Diamonds, Spades, Clubs}
enum CardValue {Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace}
public class Card {
    int pointValue;
    String suite;
    String value;

    Card(String suit, String value) {
        this.suite = suit;
        this.value = value;
    }

    public String getSuite(){
        return suite;
    }

    public String getValue(){
        return value;
    }

    public int getPoints(){
        if(value.equals("Jack") || (value.equals("Queen"))|| (value.equals("King"))){
            return 10;
        }

        else if (value.equals("Ace")){
            return 1;
        }

        else{
            return Integer.parseInt(value);
        }
    }
}




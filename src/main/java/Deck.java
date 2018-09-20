import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards;

   Deck(){

       cards = new ArrayList<Card>();
       //Initializing Deck

    String[] suite = {"Hearts", "Spades", "Clubs", "Diamonds"};
    String[] value = {"Ace", "2", "3", "4","5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

        for( int i = 0; i < suite.length; i++ ){
            for(int n = 0; n < value.length; n++){
                cards.add(new Card(suite[i], value[n]));
            }
        }
    }
    public void shuffle(){ //I'm actually confused as to why this works like this.
        ArrayList<Card> comp = cards;
         while(true){
             Collections.shuffle(cards);

             if ((comp.equals(cards))){
                 break;
             }
         }


    }

    public ArrayList<Card> getCards(){
       return cards;
    }

    public int getSize(){
       return cards.size();
    }



}

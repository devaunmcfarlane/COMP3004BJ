import java.util.ArrayList;
import java.util.Collections;

public class Deck {
   private  ArrayList<Card> cards;

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
    public void shuffle(){
        ArrayList<Card> comp = cards;
        System.out.println(cards.get(0).toString());
         while(true){
             Collections.shuffle(cards);

             if ((comp.equals(cards))){
                 break;
             }


         }
        System.out.println(cards.get(0).toString());

    }

    public ArrayList<Card> getCards(){
       return cards;
    }



}

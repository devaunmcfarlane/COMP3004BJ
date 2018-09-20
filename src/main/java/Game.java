import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Player user;
    Player dealer;
    Deck deck;



    public void launch(){
        char choice;

        while(1 == 1){ //Input Loop only breaks if user enters C or F, handles unexpected chars.
            System.out.println("For Console Input Press C, for File Input press F");
            Scanner input = new Scanner(System.in);
            choice = input.next().charAt(0);

            if ((choice == 'C') || (choice == 'c') || (choice == 'F') || (choice == 'f')){
                break;
            }
        }

        if


    }

    public void deal(){

    }

    public void hit(Player player){

    }


}

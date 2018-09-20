import java.util.ArrayList;
import java.util.Scanner;



public class Game {

    Player user;
    Player dealer;
    Deck deck;



    public void launch(){
        char choice;
        Scanner input = new Scanner(System.in);

        while(1 == 1){ //Input Loop only breaks if user enters C or F, handles unexpected chars.
            System.out.println("For Console Input Press C, for File Input press F");

            choice = input.next().charAt(0);

            if ((choice == 'C') || (choice == 'c') || (choice == 'F') || (choice == 'f')){
                break;
            }
        }

        if((choice == 'C') || (choice == 'c')) {
            while (true) {
                System.out.println("Welcome to COMP3004 BlackJack.");
                System.out.println("Shuffling Cards...");
                deck.shuffle();
                System.out.println("Dealing Cards...");
                deal();



                //Asking To Play Again
                System.out.println("Would you like to play again? (Y or N)");
                choice = input.next().charAt(0);

            }

                System.out.println("Thanks For Playing!");
                System.exit(0);
        }

        else{
            //Enter File Game Loop
        }



    }

    public void deal(){

    }

    public void hit(Player player){

    }


    public Player getPlayer(){
        return user;
    }


}

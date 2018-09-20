import java.util.ArrayList;
import java.util.Scanner;



public class Game {

    Player user = new Player ("Player");
    Player dealer = new Player("Dealer");
    Deck deck = new Deck();



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
                System.out.println("Enter your name?");
                String username = input.next();
                user.setName(username);

                System.out.println("Shuffling Cards...");
                deck.shuffle();
                System.out.println("Dealing Cards...");
                deal();




                //Asking To Play Again
                System.out.println("Would you like to play again? (Y or N)");


                while(true){
                    choice = input.next().charAt(0);
                    if ((choice == 'Y') || (choice == 'y') || (choice == 'N') || (choice == 'n')){
                        break;
                    }
                }

                if ((choice == 'N') || (choice == 'n')){
                    break;
                }

            }

                System.out.println("Thanks For Playing!");
                System.exit(0);
        }

        else{
            //Enter File Game Loop
        }



    }

    public void deal(){
        //User receives their cards first

       user.getHand().add(deck.getCards().get(deck.getSize() - 1));
        deck.getCards().remove(deck.getCards().get(deck.getSize()-1));
        user.getHand().add(deck.getCards().get(deck.getSize() - 1));
        deck.getCards().remove(deck.getCards().get(deck.getSize()-1));

        //Dealer receives their cards
        dealer.getHand().add(deck.getCards().get(deck.getSize() - 1));
        deck.getCards().remove(deck.getCards().get(deck.getSize()-1));
        dealer.getHand().add(deck.getCards().get(deck.getSize() - 1));
        deck.getCards().remove(deck.getCards().get(deck.getSize()-1));

        //Hide one of the dealers cards
        dealer.getHand().get(0).setVisibility(false);

    }

    public void hit(Player player){
        player.getHand().add(deck.getCards().get(deck.getSize() - 1));
        deck.getCards().remove(deck.getCards().get(deck.getSize()-1));
    }


    public Player getPlayer(){
        return user;
    }

    public Player getDealer(){
        return dealer;
    }


}

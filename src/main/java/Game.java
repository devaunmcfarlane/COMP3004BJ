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
                checkBJ(user);
                checkBJ(dealer);






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
        hit(user);
        hit(user);

        hit(dealer);
        hit(dealer);

        //Hide one of the dealers cards
        dealer.getHand().get(0).setVisibility(false);

    }

    public void hit(Player player){

        if((user.getTotalPoints() <= 10) && (deck.getCards().get(deck.getSize()- 1).getValue().equals("Ace"))){
            deck.getCards().get(deck.getSize()-1).setPoints(11);
        }
        player.getHand().add(deck.getCards().get(deck.getSize() - 1));
        deck.getCards().remove(deck.getCards().get(deck.getSize()-1));


    }


    public Player getPlayer(){
        return user;
    }

    public Player getDealer(){
        return dealer;
    }

    public boolean checkBJ(Player player){
        if((player.getHand().size() == 2)  && ((player.getHand().get(0).getValue().equals("Ace")) && ((player.getHand().get(1).getValue().equals("King"))))){
            return true;
        }

        else if ((player.getHand().size() == 2)  && ((player.getHand().get(0).getValue().equals("Ace")) && ((player.getHand().get(1).getValue().equals("Queen"))))){
            return true;
        }

        else if ((player.getHand().size() == 2)  && ((player.getHand().get(0).getValue().equals("Ace")) && ((player.getHand().get(1).getValue().equals("Jack"))))){
            return true;
        }

        else if ((player.getHand().size() == 2)  && ((player.getHand().get(0).getValue().equals("Ace")) && ((player.getHand().get(1).getValue().equals("10"))))){
            return true;
        }

        else if ((player.getHand().size() == 2)  && ((player.getHand().get(0).getValue().equals("King")) && ((player.getHand().get(1).getValue().equals("Ace"))))){
            return true;
        }

        else if ((player.getHand().size() == 2)  && ((player.getHand().get(0).getValue().equals("Queen")) && ((player.getHand().get(1).getValue().equals("Ace"))))){
            return true;
        }

        else if ((player.getHand().size() == 2)  && ((player.getHand().get(0).getValue().equals("Jack")) && ((player.getHand().get(1).getValue().equals("Ace"))))){
            return true;
        }

        else if ((player.getHand().size() == 2)  && ((player.getHand().get(0).getValue().equals("10")) && ((player.getHand().get(1).getValue().equals("Ace"))))){
            return true;
        }



        return false;
    }

    public boolean checkBust(Player player){
        if (player.getTotalPoints() > 21){

            //Check for Aces and attempt to reduce points
            for(int i = 0; i <= player.getHand().size() -1; i++){
                if(player.getHand().get(i).getValue().equals("Ace")){
                    player.getHand().get(i).setPoints(1);

                    if(player.getTotalPoints() <= 21){
                        return false;
                    }
                }

            }
            return true;
        }
       else {
           return false;
        }
    }
}



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Game {

    Player user = new Player ("Player");
    Player dealer = new Player("Dealer");
    Deck deck = new Deck();
    char choice;
    Scanner input = new Scanner(System.in);


    public void launch(){


        while(true){ //Input Loop only breaks if user enters C or F, handles unexpected chars.
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
                if((checkBJ(user) == true)&&(checkBJ(dealer) == false)){
                    System.out.println("Blackjack! " + user.getName() + " wins!");
                }

                else if(checkBJ(dealer) == true){
                    System.out.println("Blackjack! The Dealer wins!");
                }

                else{
                    userTurn();
                    dealerTurn();
                    System.out.println("The Winner is " + checkWinner().getName() + " !!");



                }







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
                resetCards();

            }

                System.out.println("Thanks For Playing!");
                System.exit(0);
        }

        else{
            //Enter File Game Loop
            boolean hasError = false;
            String[] commands = new String[20];
            System.out.println("Ensure text file is in src/main/resources");
            System.out.println("What is the File  name?");
            String name= input.nextLine();
            String Path = "C:\\Users\\DeVaun\\Desktop\\COMP3004BJ\\src\\main\\resources"+name+".txt" ;
            File file = new File(Path);
            Scanner sc = null;
            try {
                sc = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("e.printStackTrace():File Doesnt Exist");
                hasError = true;
            }
            if(!hasError) {
                while(sc.hasNextLine()) {
                    String line = sc.nextLine();
                    commands = line.split(" ");
                }

            }
            String suite = "";
            String value = "";
            for(int i = 0; i < 4; i++){

                char c = commands[i].charAt(0);
                char n = commands[i]. charAt(1);

                if(c == 'S'){
                    suite = "Spades";
                }

                else if ( c == 'C'){
                    suite = "Clubs";
                }

                else if ( c == 'H'){
                    suite = "Hearts";
                }
                else if ( c == 'D'){
                    suite = "Diamonds";
                }

                if (n == 'A'){
                    value = "Ace";
                }

                else if (n == '2'){
                    value = "2";
                }

                else if (n == '3'){
                    value = "3";
                }
                else if (n == '4'){
                    value = "4";
                }
                else if (n == '5'){
                    value = "5";
                }
                else if (n == '6'){
                    value = "6";
                }
                else if (n == '7'){
                    value = "7";
                }
                else if (n == '8'){
                    value = "8";
                }
                else if (n == '9'){
                    value = "9";
                }
                else if (n == '0'){
                    value = "10";
                }
                else if (n == 'J'){
                    value = "Jack";
                }
                else if (n == 'Q'){
                    value = "Queen";
                }
                else if (n == 'K'){
                    value = "King";
                }

                if( i < 2){
                    user.getHand().add( new Card(suite, value));
                }

                else{
                    dealer.getHand().add(new Card (suite, value));
                }

            }

            if((checkBJ(user) == true)&&(checkBJ(dealer) == false)){
                System.out.println("Blackjack! " + user.getName() + " wins!");
                System.exit(0);
            }

            else if(checkBJ(dealer) == true){
                System.out.println("Blackjack! The Dealer wins!");
                System.exit(0);
            }

            int pos = 0;
            for(int i = 4; i <commands.length; i++){
                if(commands[i] == "H"){
                    i++;
                    char c = commands[i].charAt(0);
                    char n = commands[i]. charAt(1);

                    if(c == 'S'){
                        suite = "Spades";
                    }

                    else if ( c == 'C'){
                        suite = "Clubs";
                    }

                    else if ( c == 'H'){
                        suite = "Hearts";
                    }
                    else if ( c == 'D'){
                        suite = "Diamonds";
                    }

                    if (n == 'A'){
                        value = "Ace";
                    }

                    else if (n == '2'){
                        value = "2";
                    }

                    else if (n == '3'){
                        value = "3";
                    }
                    else if (n == '4'){
                        value = "4";
                    }
                    else if (n == '5'){
                        value = "5";
                    }
                    else if (n == '6'){
                        value = "6";
                    }
                    else if (n == '7'){
                        value = "7";
                    }
                    else if (n == '8'){
                        value = "8";
                    }
                    else if (n == '9'){
                        value = "9";
                    }
                    else if (n == '0'){
                        value = "10";
                    }
                    else if (n == 'J'){
                        value = "Jack";
                    }
                    else if (n == 'Q'){
                        value = "Queen";
                    }
                    else if (n == 'K'){
                        value = "King";
                    }

                    fileHit(user, new Card(suite, value));
                    user.displayHand();
                    if(checkBust(user) == true){
                        System.out.println("You bust! Dealer Wins!");
                        System.exit(0);
                    }
                }

                else if (commands[i] == "S"){
                    pos = i;
                    System.out.println(user.getName() + " stands");
                    user.displayHand();
                    break;
                }


            }
            for(int i = pos; i <commands.length; i++ ){
                if(commands[i] == "H"){
                    i++;
                    char c = commands[i].charAt(0);
                    char n = commands[i]. charAt(1);

                    if(c == 'S'){
                        suite = "Spades";
                    }

                    else if ( c == 'C'){
                        suite = "Clubs";
                    }

                    else if ( c == 'H'){
                        suite = "Hearts";
                    }
                    else if ( c == 'D'){
                        suite = "Diamonds";
                    }

                    if (n == 'A'){
                        value = "Ace";
                    }

                    else if (n == '2'){
                        value = "2";
                    }

                    else if (n == '3'){
                        value = "3";
                    }
                    else if (n == '4'){
                        value = "4";
                    }
                    else if (n == '5'){
                        value = "5";
                    }
                    else if (n == '6'){
                        value = "6";
                    }
                    else if (n == '7'){
                        value = "7";
                    }
                    else if (n == '8'){
                        value = "8";
                    }
                    else if (n == '9'){
                        value = "9";
                    }
                    else if (n == '0'){
                        value = "10";
                    }
                    else if (n == 'J'){
                        value = "Jack";
                    }
                    else if (n == 'Q'){
                        value = "Queen";
                    }
                    else if (n == 'K'){
                        value = "King";
                    }

                    fileHit(dealer, new Card(suite, value));

                    if(checkBust(dealer) == true){
                        dealer.displayHand();
                        System.out.println("You bust! Dealer Wins!");
                        break;
                    }
                }

                else if (commands[i] == "S"){
                    pos = i;
                    System.out.println("Dealer stands");
                    dealer.displayHand();
                    break;
                }
            }



            System.out.println("The Winner is " + checkWinner().getName() + " !!");
            System.exit(0);

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

        if((player.getTotalPoints() <= 10) && (deck.getCards().get(deck.getSize()- 1).getValue().equals("Ace"))){
            deck.getCards().get(deck.getSize()-1).setPoints(11);
        }
        player.getHand().add(deck.getCards().get(deck.getSize() - 1));
        deck.getCards().remove(deck.getCards().get(deck.getSize()-1));


    }

    public void fileHit(Player player, Card card){
        if((player.getTotalPoints() <= 10) && (card.getValue().equals("Ace"))){
            card.setPoints(11);
        }
        player.getHand().add(card);
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

    public void userTurn(){
        System.out.println(user.getName() + "'s turn");
        user.displayHand();
        while(true){
            while(true){
                System.out.println("Would you like to Hit or Stand (H or S)");
                choice = input.next().charAt(0);
                if ((choice == 'H') || (choice == 'h') || (choice == 'S') || (choice == 's')){
                    break;
                }
            }

            if ((choice == 'H') || (choice == 'h')){
                hit(user);
                user.displayHand();
                if(checkBust(user) == true){
                    System.out.println("You bust! Dealer Wins!");
                    break;
                }

            }

            else if ((choice == 'S') || (choice == 's')){

                System.out.println(user.getName() + " stands");
                user.displayHand();
                break;
            }

        }
    }

    public void dealerTurn(){
        System.out.println("Dealer's turn");
        dealer.getHand().get(0).setVisibility(true);

        while(true){


            if(dealer.getTotalPoints() <= 16){
                hit(dealer);
                System.out.println("Dealer Hits");
                if(checkBust(dealer) == true){
                    System.out.println("Dealer bust! You win!");
                }
            }

            else if((dealer.softSeventeen() == true)){
                hit(dealer);
                if(checkBust(dealer) == true){
                    System.out.println("Dealer bust! You win!");
                }
            }

            else {
                System.out.println("Dealer Stands");
                dealer.displayHand();
                break;
            }


        }
    }

    public Player checkWinner(){

        if ((checkBust(user) == false) && (checkBust(dealer) == false)){
            if(user.getTotalPoints() > dealer.getTotalPoints()){
                return user;
            }
            return dealer;
        }

        else if (checkBust(user) == true){
            return dealer;
        }

        if (checkBust(dealer) == true){
            return user;
        }

        return dealer;


    }

    public void resetCards(){
        deck = new Deck();
        user = new Player("user");
        dealer = new Player("Dealer");

    }
}


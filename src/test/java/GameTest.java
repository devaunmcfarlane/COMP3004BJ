import junit.framework.TestCase;

public class GameTest extends TestCase {

    public void testDeal() {
        Game game = new Game();

        game.deal();

        assertEquals(2, game.getPlayer().getHand().size());
        assertEquals(2, game.getDealer().getHand().size());
    }

    public void testUserHit() {
        Game game = new Game();
        game.deal();
        int prevSize = game.user.getHand().size();
        game.hit(game.user);
        assertEquals(prevSize + 1, game.user.getHand().size());

    }

    public void testGetPlayer() {
        Game game = new Game();
        Player p1 = game.getPlayer();

        assertTrue(p1 instanceof Player);
    }

    public void testGetDealer() {
        Game game = new Game();
        Player d1 = game.getDealer();

        assertTrue(d1 instanceof Player);
    }

    public void testDealerVisibility() {
        Game game = new Game();
        game.deal();

        assertEquals(false, game.getDealer().getHand().get(0).getVisibility());
    }

    public void testCheckUserBust(){
        Game game = new Game();
        game.deal();
        Card c1 = new Card("Diamonds", "King");
        Card c2 = new Card("Diamonds", "Jack");
        game.hit(game.user);
        Card c3 = new Card ("Diamonds", "Queen");
        game.user.getHand().set(0,c1);
        game.user.getHand().set(1,c2);
        game.user.getHand().set(2,c3);
        assertEquals(true, game.checkBust(game.user));
    }

    public void testCheckUserBJ(){
        Game game = new Game();
        game.deal();
        Card c1 = new Card("Diamonds", "Ace");
        Card c2 = new Card("Diamonds", "Jack");
        game.user.getHand().set(0,c1);
        game.user.getHand().set(1,c2);
        assertEquals(true, game.checkBJ(game.user));
    }

    public void testCheckDealerBJ(){
        Game game = new Game();
        game.deal();
        Card c1 = new Card("Diamonds", "Ace");
        Card c2 = new Card("Diamonds", "Jack");
        game.dealer.getHand().set(0,c1);
        game.dealer.getHand().set(1,c2);
        assertEquals(true, game.checkBJ(game.dealer));
    }

    public void testAce11then1(){
        Game game = new Game();
        game.deal();
        Card c1 = new Card("Diamonds", "Ace");
        Card c2 = new Card("Diamonds", "Jack");

        c1.setPoints(11);
        game.user.getHand().set(0,c1);
        game.user.getHand().set(1,c2);
        game.hit(game.user);
        game.checkBust(game.user);
        assertEquals(1, game.user.getHand().get(0).getPoints());
    }

    public void testDealerUnder16(){
        Game game = new Game();
        game.deal();

        game.dealer.getHand().set(0, new Card ("Hearts", "5"));
        game.dealer.getHand().set(1, new Card ("Hearts", "7"));

        game.dealerTurn();

        assertTrue(game.dealer.getHand().size() > 2);
    }

    public void testDealerSoft17(){
        Game game = new Game();
        game.deal();

        game.dealer.getHand().set(0, new Card ("Hearts", "Ace"));
        game.dealer.getHand().set(1, new Card ("Hearts", "6"));

        game.dealerTurn();

        assertTrue(game.dealer.getHand().size() > 2);
    }

    public void testDealerHitRepeat(){
        Game game = new Game();
        game.deal();

        game.dealer.getHand().set(0, new Card ("Hearts", "2"));
        game.dealer.getHand().set(1, new Card ("Hearts", "2"));

        game.dealerTurn();

        assertTrue(game.dealer.getHand().size() > 2);
    }

    public void testDealerBust(){
        Game game = new Game();
        game.deal();

        game.dealer.getHand().set(0, new Card ("Hearts", "10"));
        game.dealer.getHand().set(1, new Card ("Hearts", "6"));
        game.deck.getCards().set(game.deck.getCards().size() -1, new Card ("Hearts", "10"));
        game.dealerTurn();

        assertTrue(game.dealer.getTotalPoints() > 21);
    }

    public void testCheckWinner(){
        Game game = new Game();
        game.deal();

        game.dealer.getHand().add(new Card "Hearts", "10");
        game.dealer.getHand().set(0, new Card ("Hearts", "2"));
        game.dealer.getHand().set(1, new Card ("Hearts", "3"));

        game.user.getHand().add(new Card "Hearts", "10");
        game.user.getHand().set(0, new Card ("Diamonds", "3"));
        game.user.getHand().set(1, new Card ("Hearts", "3"));

        game.checkWinner();
    }


}

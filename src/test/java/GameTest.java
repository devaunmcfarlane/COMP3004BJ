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

    public void testCheckBust(){
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

    public void testCheckDealerBJ
}

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
        assertEquals(true, game.checkBust(game.user));
    }

    public void testCheckBJ(){
        Game game = new Game();
        game.deal();
        assertEquals(true, game.checkBust(game.user));
    }
}

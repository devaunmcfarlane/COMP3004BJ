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

        Card oldLast = game.getPlayer().getHand().get((game.getPlayer().getHand().size() - 1));
        game.hit(game.user);

        assertFalse(oldLast.equals(game.getPlayer().getHand().get((game.getPlayer().getHand().size() - 1))));


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
}

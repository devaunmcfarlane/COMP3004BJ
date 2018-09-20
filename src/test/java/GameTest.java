import junit.framework.TestCase;

public class GameTest extends TestCase {

    public void testUserHit(){
        Game game = new Game();
        Card oldLast = game.getPlayer().getHand().get((game.getPlayer().getHand().size() -1));

        game.hit(game.user);

        assertFalse(oldLast.equals(game.getPlayer().getHand().get((game.getPlayer().getHand().size() -1))));



    }

    public void testGetPlayer(){
        Player p1 = new Player("beta");

        assertTrue(p1 instanceof Player);
    }

}

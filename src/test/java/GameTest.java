import junit.framework.TestCase;

public class GameTest extends TestCase {

    public void testHit(){
        Game game = new Game();
        game.getPlayer().hit();
        Card oldLast = game.getPlayer().getHand().get(getPlayer().getHand().size() -1);

    }



}

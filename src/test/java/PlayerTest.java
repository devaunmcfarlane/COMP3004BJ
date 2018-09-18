import junit.framework.TestCase;

public class PlayerTest extends TestCase {

    public void testGetPoints(){
        Player p1 = new Player ();

        assertEquals(10, p1.getPoints());
    }
}

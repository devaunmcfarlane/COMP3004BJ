import junit.framework.TestCase;

public class CardTest extends TestCase {

    public void testGetSuit(){
        Card card = new Card();

        assertEquals(card.suite, card.getSuite());
    }

    public void testGetValue(){
        Card card = new Card();

        assertEquals(card.suite, card.getValue());
    }
}

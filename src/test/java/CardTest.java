import junit.framework.TestCase;

public class CardTest extends TestCase {

    public void testGetSuit(){
        Card card = new Card("Diamonds", "Ace");

        assertEquals(card.suite, card.getSuite());
    }

    public void testGetValue(){
        Card card = new Card("Diamonds","Ace");

        assertEquals(card.value, card.getValue());
    }
}

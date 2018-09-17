import junit.framework.TestCase;

import java.lang.reflect.Field;

public class CardTest extends TestCase {

    public void testGetSuit(){
        Card card = new Card("Diamonds", "Ace");

        assertEquals(card.suite, card.getSuite());
    }

    public void testGetValue(){
        Card card = new Card("Diamonds","Ace");

        assertEquals(card.value, card.getValue());
    }

    public void testGetPoints(){
        Card card = new Card("Diamonds","Jack");

        assertEquals(10, card.getPoints());
    }

    public void testSetPoints(){
        Card card = new Card("Diamonds", "Ace");

        card.setPoints(11);

        final Field field = card.getClass().getDeclaredField("pointValue")
        assertEquals(11, card.getPoints());
    }
}

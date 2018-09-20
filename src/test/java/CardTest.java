import junit.framework.TestCase;



public class CardTest extends TestCase {

    public void testGetSuit(){
        Card card = new Card("Diamonds", "Ace");

        assertEquals("Diamonds", card.getSuite());
    }

    public void testGetValue(){
        Card card = new Card("Diamonds","Ace");

        assertEquals("Ace", card.getValue());
    }

    public void testGetPoints(){
        Card card = new Card("Diamonds","Jack");

        assertEquals(10, card.getPoints());
    }

    public void testSetPoints(){
        Card card = new Card("Diamonds", "Ace");

        card.setPoints(11);
        assertEquals(11, card.getPoints());
    }

    public void testCardToString(){
        Card card = new Card("Diamonds", "Ace");

        assertEquals("Ace of Diamonds", card.toString());
    }


}

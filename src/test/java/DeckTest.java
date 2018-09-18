import junit.framework.TestCase;

public class DeckTest extends TestCase {

    public void testInit(){
        Deck testDeck = new Deck;
        testDeck.init();
        Card top = testDeck.cards.get(0);
        assertEquals(card1, top);
    }
    public void testShuffle(){

    }

}

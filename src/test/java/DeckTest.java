import junit.framework.TestCase;

public class DeckTest extends TestCase {

    public void testGetAtIndex(){
        Deck testDeck = new Deck();
    }

    public void testShuffle(){
        Deck testDeck = new Deck();
        Card prevTop = testDeck.getCards().get(0);

        testDeck.shuffle();

        //Manual check to see if the top card is the same as before (shouldn't be)
        if(testDeck.getCards().get(0) == prevTop){
            assertEquals(1,2);
        }

        else{ //Since we know the deck is shuffled we check to ensure no cards were lost
            assertEquals(52, testDeck.getCards().size());
        }
    }
    public void testInitialize() {
        Deck deck = new Deck();

        assertEquals(52, deck.getCards().size());
    }
}

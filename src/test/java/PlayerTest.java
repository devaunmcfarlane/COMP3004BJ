import junit.framework.TestCase;

public class PlayerTest extends TestCase {

    public void testGetPointsOneCard(){
        Player p1 = new Player ("tester");
        Card c1 = new Card("Diamonds", "Jack");
        p1.hand.add(c1);
        assertEquals(10, p1.getTotalPoints());
    }


    public void testGetPointsMultipleCards(){
        Player p1 = new Player("tester");
        Card c1 = new Card("Diamonds", "Jack");
        p1.hand.add(c1);


        Card c2 = new Card("Hearts", "5");
        p1.hand.add(c2);



        Card c3 = new Card("Hearts", "6");
        p1.hand.add(c3);

        assertEquals(21, p1.getTotalPoints());
    }


    public void testGetName(){
        Player p1 = new Player("Devo");

        assertEquals("Devo", p1.getName());
    }

    public void testGetHand(){
        Player p1 = new Player("beta");

        assertEquals(p1.hand, p1.getHand());
    }
}

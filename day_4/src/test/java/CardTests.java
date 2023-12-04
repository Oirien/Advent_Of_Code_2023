import org.example.Card;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardTests {
    String testString = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53";
    Card testCard = new Card(testString);

    @Test
    public void canSortCardData(){
        assertEquals(1, testCard.getCardNumber());
        assertTrue(testCard.getPlayingNumbers().size() > 0);
        assertTrue(testCard.getWinningNumbers().size() > 0);
    }
    @Test
    public void canGetPointsFromCard(){
        assertEquals(8, testCard.getScorePoints());
    }
}

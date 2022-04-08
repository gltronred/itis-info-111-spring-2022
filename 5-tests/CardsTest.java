import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
// Add imports here!

public class CardsTest {
  @Test
  public void aceCountsTen() {
    // Enter code here
    Cards cards = new Cards();
    cards.add(Card.TEN);
    cards.add(Card.ACE);
    assertEquals(cards.sum(), 21);
  }

  @Test
  public void valTest() {
    // Enter code here
    assertEquals(Cards.val(Card.C2), 2);
  }
  @Test
  public void sumOf() {
    // Enter code here

    Cards c = new Cards();
    c.add(Card.C2);
    c.add(Card.TEN);
    assertEquals(c.sum(), 12);

  }
  @Test
  public void cInitStorageTest() {
    Cards cards = new Cards();
    assertEquals(cards.getStorage().size(), 0);
    cards.add(Card.C2);
    cards.add(Card.ACE);
    assertEquals(cards.getStorage().size(), 2);
  }
  @Test
  public void c2returns2() {
    // Enter code here
    Cards cards = new Cards();
    cards.add(Card.C2);
    assertEquals(cards.sum(), 2);
  }
  @Test
  public void emptyCardsReturn0() {
    // Enter code here
    Cards cards = new Cards();
    assertEquals(cards.sum(), 0);
  }
}

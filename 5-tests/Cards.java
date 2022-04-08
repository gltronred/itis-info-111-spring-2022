import java.util.List;
import java.util.ArrayList;
enum Card {
  ACE, C2, C3, C4, C5,
  C6, C7, C8, C9, TEN,
  JACK, QUEEN, KING;
}

class Cards {
  private List<Card> cardsStorage;
  public Cards() {
    cardsStorage = new ArrayList<>();
  }
  public void add(Card c) {
      cardsStorage.add(c);
  }
  public int sum() {
    return cardsStorage.stream()
      .mapToInt(Cards::val)
      .sum();
    }

  public List<Card> getStorage() {
    return cardsStorage;
  }
  public static int val(Card c) {
    switch (c) {
      case ACE: return 1;
      case C2: return 2;
      case C3: return 3;
      case C4: return 4;
      case C5: return 5;
      case C6: return 6;
      case C7: return 7;
      case C8: return 8;
      case C9: return 9;
    }
    return 10;
  }
}

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Cards cards = new Cards();
    cards.add(Card.C2);
    cards.add(Card.C7);
    cards.add(Card.ACE);
    System.out.println(cards.sum());
  }
}

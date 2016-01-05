import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {
  @Test
  public void scrabbleScore_returnsAScrabbleScoreForALetter_1() {
    App app = new App();
    Integer score = 1;
    assertEquals(score, app.scrabbleScore("A"));
  }

  @Test
  public void scrabbleScore_returnsAScrabbleScoreForAnotherLetter_4() {
    App app = new App();
    Integer score = 10;
    assertEquals(score, app.scrabbleScore("Z"));


  }
}

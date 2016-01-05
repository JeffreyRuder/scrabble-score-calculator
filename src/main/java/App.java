import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {
  public static void main(String[] args) {}

  public static Integer scrabbleScore (String inputWord) {
    char[] inputWordArray = inputWord.toCharArray();
    Integer runningScore = 0;

    HashMap<Object, Integer> scoreMap = new HashMap<Object, Integer>();
    scoreMap.put('A', 1);
    scoreMap.put('Z', 10);

    for (int i = 0; i < inputWordArray.length; i++) {
      runningScore = runningScore + scoreMap.get(inputWordArray[i]);
    }

    return runningScore;

  }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/score", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/score.vtl");

      String inputWord = request.queryParams("word");
      Integer scrabbleScore = scrabbleScore(inputWord);

      model.put("score", scrabbleScore);
      model.put("word", inputWord);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

  public static Integer scrabbleScore (String inputWord) {
    inputWord = inputWord.replaceAll("\\s+","");
    inputWord = inputWord.toUpperCase();
    char[] inputWordArray = inputWord.toCharArray();
    Integer runningScore = 0;
    String[] letterArray = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    Integer[] scrabblePoints = { 1, 2, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

    for (int i = 0; i < inputWordArray.length; i++) {
      String letter = String.valueOf(inputWordArray[i]);
      Integer letterIndex = Arrays.asList(letterArray).indexOf(letter);
      runningScore = runningScore + scrabblePoints[letterIndex];
    }

    return runningScore;

  }

}

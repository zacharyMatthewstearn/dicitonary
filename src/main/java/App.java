import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
		String layout = "templates/layout.vtl";

		get("/", (request,response) -> {
			Map<String,Object> model = new HashMap<String,Object>();
			model.put("template","templates/index.vtl");
			return new ModelAndView(model,layout);
		}, new VelocityTemplateEngine());

		post("/", (request,response) -> {
			Map<String,Object> model = new HashMap<String,Object>();

			List<Word> words = new ArrayList<Word>();
			if(request.session().attribute("words") == null){
        List<Word> temp = new ArrayList<Word>();
        request.session().attribute("words", temp);
      }

			words = request.session().attribute("words");
			Word newWord = new Word(request.queryParams("inputWord"));
			words.add(newWord);

			model.put("words",words);
			model.put("template","templates/index.vtl");
			return new ModelAndView(model,layout);
		}, new VelocityTemplateEngine());
	}
}

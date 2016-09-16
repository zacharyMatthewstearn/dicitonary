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

		post("/words", (request,response) -> {
			Map<String,Object> model = new HashMap<String,Object>();
			List<Word> words = new ArrayList<Word>();
			Word selected = Word.findWord(request.params(":word"));
			if(request.session().attribute("words") == null){
        List<Word> temp = new ArrayList<Word>();
        request.session().attribute("words", temp);
      }
			words = request.session().attribute("words");
			Word newWord = new Word(request.queryParams("inputWord"));
			boolean wordsContainsWord = false;
			for(Word word:words){
				if(word.getWord().equals(newWord.getWord()))
					wordsContainsWord = true;
			}
			if(!wordsContainsWord){
				words.add(newWord);
				selected = newWord;
			}
			model.put("words",words);
			model.put("selected",selected);
			model.put("template","templates/index.vtl");
			return new ModelAndView(model,layout);
		}, new VelocityTemplateEngine());

		get("/definitions/:word", (request,response) -> {
			Map<String,Object> model = new HashMap<String,Object>();
			List<Word> words = request.session().attribute("words");
			Word selected = Word.findWord(request.params(":word"));
			if(selected != null)
				System.out.println("selected == " + selected.getWord());
			else
				System.out.println("selected is null!");
			List<Definition> definitions = new ArrayList<Definition>();
			if(request.session().attribute("definitions") == null){
        List<Definition> temp = new ArrayList<Definition>();
        request.session().attribute("definitions", temp);
      }
			model.put("words",words);
			model.put("selected",selected);
			model.put("definitions",definitions);
			model.put("template","templates/index.vtl");
			return new ModelAndView(model,layout);
		}, new VelocityTemplateEngine());

		post("/definitions/:word", (request,response) -> {
			Map<String,Object> model = new HashMap<String,Object>();
			List<Word> words = request.session().attribute("words");
			Word selected = Word.findWord(request.params(":word"));
			List<Definition> definitions = new ArrayList<Definition>();
			if(request.session().attribute("definitions") == null){
        List<Definition> temp = new ArrayList<Definition>();
        request.session().attribute("definitions", temp);
      }
			selected.addDefinition(request.queryParams("inputDefinition"));
			model.put("words",words);
			model.put("selected",selected);
			model.put("definitions",definitions);
			model.put("template","templates/index.vtl");
			return new ModelAndView(model,layout);
		}, new VelocityTemplateEngine());
	}
}

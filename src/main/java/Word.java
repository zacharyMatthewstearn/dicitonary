import java.util.List;
import java.util.ArrayList;

public class Word {
	private static List<Word> allWords = new ArrayList<Word>();
	private String mWord;
	private List<String> mDefinitions;

	public Word(String _word) {
		mWord = _word;
		mDefinitions = new ArrayList<String>();
		if(Word.findWord(mWord) == null)
			allWords.add(this);
	}

	public String getWord() {
		return mWord;
	}

	public List<String> getDefinitions() {
		return mDefinitions;
	}

	public void addDefinition(String _definition) {
		mDefinitions.add(_definition);
	}

	public static Word findWord(String _word) {
		for(Word word:allWords){
			if(word.getWord().equals(_word))
				return word;
		}
		return null;
	}
}

import java.util.List;
import java.util.ArrayList;

public class Word {
	private String mWord;
	private List<String> mDefinitions;

	public Word(String _word) {
		mWord = _word;
		mDefinitions = new ArrayList<String>();
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
}

import java.util.List;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

	@Test
	public void newWord_instantiatesCorrectly() {
		Word testWord = new Word("test");
		assertEquals(true, testWord instanceof Word);
	}

	@Test
	public void getWord_returnsMWord_String() {
		Word testWord = new Word("test");
		String expectedOutput = "test";
		assertEquals(expectedOutput, testWord.getWord());
	}

	@Test
	public void getDefinitions_returnsMDefinitions_ListString() {
		Word testWord = new Word("test");
		testWord.addDefinition("a procedure intended to establish the quality, performance, or reliability of something, especially before it is taken into widespread use");
		List<String> expectedOutput = new ArrayList<String>();
		expectedOutput.add("a procedure intended to establish the quality, performance, or reliability of something, especially before it is taken into widespread use");
		assertEquals(expectedOutput, testWord.getDefinitions());
	}

	@Test
	public void findWord_returnsNullIfNotInAllWords_null() {
		Word testWord = new Word("test");
		Word expectedOutput = null;
		assertEquals(expectedOutput, Word.findWord("bazooka"));
	}

	@Test
	public void findWord_returnsCorrectWordFromAllWords_String() {
		Word testWord = new Word("test");
		String expectedOutput = "test";
		assertEquals(expectedOutput, Word.findWord("test").getWord());
	}
}

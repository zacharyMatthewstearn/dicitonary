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
}

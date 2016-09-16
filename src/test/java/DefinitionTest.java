import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void newDefinition_instantiatesCorrectly() {
    Definition testDefinition = new Definition("test");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void getDefinition_returnsMDefinition_String() {
    Definition testDefinition = new Definition("test");
    String expectedOutput = "test";
    assertEquals(expectedOutput, testDefinition.getDefinition());
  }

}

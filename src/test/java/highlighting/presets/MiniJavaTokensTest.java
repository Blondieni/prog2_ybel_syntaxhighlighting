package highlighting.presets;

import static org.junit.jupiter.api.Assertions.*;

import highlighting.core.HighlightRegion;
import highlighting.regex.Token;
import java.util.List;
import org.junit.jupiter.api.Test;

class MiniJavaTokensTest {

  @Test
  void defaultTokens() {
    var tok = MiniJavaTokens.defaultTokens().getFirst();
    var l = tok.test("wuppie");
    assertTrue(l.isEmpty());
  }

  @Test
  void einzeiliger() {

    // Bereitet Test vor
    List<Token> testList = MiniJavaTokens.defaultTokens();
    Token einzeiliger = testList.get(1);
    String text = "// hallo Welt";
    HighlightRegion testRegion =
        new HighlightRegion(0, text.length(), MiniJavaColours.LINE_COMMENT_COLOUR);

    // lässt den Test durchführen
    List<HighlightRegion> kommentare = einzeiliger.test(text);
    assertEquals(kommentare.get(0), testRegion);
  }
}

package highlighting.regex;

import static org.junit.jupiter.api.Assertions.*;

import highlighting.core.HighlightRegion;
import java.util.List;
import org.junit.jupiter.api.Test;

class RegexHighlighterTest {

  // testet, dass kein Treffer gefunden wird
  @Test
  public void keinTrefferTest() {
    RegexHighlighter RegexMarkierung = new RegexHighlighter();
    List<HighlightRegion> regionen = RegexMarkierung.computeRegions("12345");
    assertTrue(regionen.isEmpty());
  }

  // Test, ob aufeinanderfolgende Markierungen gelöst werden
  @Test
  public void aufeinanderfolgendeMarkierungstest() {
    RegexHighlighter RegexMarkierung = new RegexHighlighter();
    List<HighlightRegion> regionen = RegexMarkierung.computeRegions("import return");
    assertFalse(regionen.isEmpty());
  }

  // Test, ob Konflikte aufgelöst werden
  @Test
  public void konfliktTest() {
    RegexHighlighter RegexMarkierung = new RegexHighlighter();
    List<HighlightRegion> regionen = RegexMarkierung.computeRegions("// @Override");
    assertEquals(1, regionen.size());
  }
}

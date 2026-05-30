package highlighting.presets;

import highlighting.regex.Token;
import java.util.List;
import java.util.regex.Pattern;

public final class MiniJavaTokens {

  // TODO (Phase I+II: RegexHighlighter/ScanningHighlighter)
  // TODO: Define the MiniJava tokens used by the highlighters. Each token is a mapping from a
  // regular expression to a colour (and, if applicable, a specific matching group). The order of
  // tokens in this list determines their relative priority during highlighting. One example token
  // definition is provided below; define the remaining tokens in an analogous way.

  // Basic token set for MiniJava. Extend this list with further tokens as needed (e.g. identifiers,
  // numeric literals, operators, brackets, whitespace), following the same pattern. Each token is
  // defined by a regular expression and a colour. Optionally, a specific capturing group within the
  // pattern can be selected as the "highlighted" region.
  public static List<Token> defaultTokens() {
    return List.of(
        // 0. Example: string literals (students should define further tokens below)
        Token.of(Pattern.compile("\"([^\"\\\\]|\\\\.)*\""), MiniJavaColours.STRING_LITERAL_COLOUR),

        // TODO: Define additional tokens for MiniJava, e.g. character literals, keywords,
        // annotations, comments, identifiers, numbers, operators, etc.

        //  // -> FÜr Kommentar
        //  . -> beliebiges Zeichen
        // 1.  * -> beliebig viel oder kein
        Token.of(Pattern.compile("//.*"), MiniJavaColours.LINE_COMMENT_COLOUR),

        // \ escape
        // \s Whitespace (Leerzeichen, Tabulator, Newline)
        // \S jedes Zeichen außer Whitespaces: [^\s]
        // *? non-greedy Variante von X* - Stopt beim ersten Sternchen
        // 2. [] Behälter zum auswählen
        Token.of(Pattern.compile("/\\*[\\s\\S]*?\\*/"), MiniJavaColours.BLOCK_COMMENT_COLOUR),

        // 3. Javadoc Kommentare /** .. */
        Token.of(Pattern.compile("/\\*\\*[\\s\\S]*?\\*/"), MiniJavaColours.JAVADOC_COMMENT_COLOUR),

        // 4. ein Zeichen zwischen 'und  '
        Token.of(Pattern.compile("'([^\"\\\\]|\\\\.)'"), MiniJavaColours.CHAR_LITERAL_COLOUR),

        // 5. Keywords package, import, class, public, private, final, return, null, new
        Token.of(
            Pattern.compile("\\b(package|import|class|public|private|final|return|null|new)\\b"),
            MiniJavaColours.KEYWORD_COLOUR),

        // 6. Annotationen beginnen mit @, gefolgt von Buchstaben oder Minuszeichen
        Token.of(Pattern.compile("@+"), MiniJavaColours.ANNOTATION_COLOUR));
  }
}

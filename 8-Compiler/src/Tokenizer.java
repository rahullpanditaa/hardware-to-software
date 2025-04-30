import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private String sourceCode;

    public Tokenizer(String jackFile) {
        try {
            this.sourceCode = new String(Files.readAllBytes(Paths.get(jackFile)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSourceCode() {
        return this.sourceCode;
    }

    private void setSourceCode(String replacement) {
        this.sourceCode = replacement;
    }

    public boolean hasMoreTokens() {
        return !sourceCode.isEmpty();
    }

    // Gets the next token from the input, makes it the current token
    public void advance() {
        removeCommentsAndWhitespace();

    }

    private void removeCommentsAndWhitespace() {
        Pattern blockCommentsPattern = Pattern.compile("//?\\*\\*? [\\S\\s]+ \\*/");
        Matcher blockCommentsMatcher = blockCommentsPattern.matcher(sourceCode);
        sourceCode = sourceCode.replaceAll("(// .*|//?\\*\\*? [\\S\\s]+ \\*/)","").strip();
//        setSourceCode(blockCommentsMatcher.replaceAll(""));
//        Pattern inlineCommentsPattern = Pattern.compile("// .*$");
//        Matcher inlineCommentsMatcher = inlineCommentsPattern.matcher(sourceCode);
//        this.sourceCode = blockCommentsMatcher.replaceAll("");
//        this.sourceCode = inlineCommentsMatcher.replaceAll("");
//        setSourceCode(inlineCommentsMatcher.replaceAll(""));
    }


}
